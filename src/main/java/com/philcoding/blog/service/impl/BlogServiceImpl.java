package com.philcoding.blog.service.impl;

import com.philcoding.blog.entity.BlogEntity;
import com.philcoding.blog.enums.StatusEnum;
import com.philcoding.blog.exception.CreateFailureException;
import com.philcoding.blog.exception.DeteleFailureException;
import com.philcoding.blog.exception.UpdateFailureException;
import com.philcoding.blog.manager.ArticleManager;
import com.philcoding.blog.model.article.ArticleDTO;
import com.philcoding.blog.model.blog.BlogDTO;
import com.philcoding.blog.model.blog.BlogPageDTO;
import com.philcoding.blog.model.pageable.PageDTO;
import com.philcoding.blog.repository.BlogRepository;
import com.philcoding.blog.service.BlogService;
import com.philcoding.blog.util.HashUtil;
import com.philcoding.blog.util.IdUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    private final ArticleManager articleManager;

    public BlogServiceImpl(BlogRepository blogRepository,
                           ArticleManager articleManager) {
        this.blogRepository = blogRepository;
        this.articleManager = articleManager;
    }

    @Override
    public BlogPageDTO findByPage(PageDTO pageDTO) {

        Sort sort = Sort.by(Sort.Direction.DESC, "updatedAt");
        Pageable pageable = PageRequest.of(pageDTO.getPage(), pageDTO.getSize(), sort);
        int publishStatus = StatusEnum.PUBLISHED.getCode();

        Page<BlogEntity> blogEntityPage = blogRepository.findAllByStatus(publishStatus, pageable);

        BlogPageDTO blogPageDTO = new BlogPageDTO();

        if (blogEntityPage.hasContent()) {

            List<BlogDTO> blogList = blogEntityPage.getContent().stream()
                    .map(BlogDTO::from)
                    .collect(Collectors.toList());

            blogPageDTO.setBlogList(blogList);
            blogPageDTO.setPageable(PageDTO.of(blogEntityPage));
        }

        return blogPageDTO;
    }

    @Override
    public BlogDTO findById(Long blogId) {

        Optional<BlogEntity> entity = blogRepository.findById(blogId);

        return entity.filter(item -> item.getStatus() == StatusEnum.PUBLISHED.getCode())
                .map(item -> {

                    ArticleDTO articleDTO = articleManager.findById(item.getArticleId());

                    BlogDTO blogDTO = BlogDTO.from(item);
                    blogDTO.setContent(articleDTO.getContent());

                    return blogDTO;

                }).orElse(BlogDTO.empty());
    }

    @Override
    @Transactional
    public BlogDTO create(BlogDTO blogDTO) {

        String titleHash = HashUtil.sha256(blogDTO.getTitle());

        // 根据博文标题，校验是否有重复博文
        BlogEntity blogEntity = blogRepository.findByTitleHash(titleHash);
        if (blogEntity != null) {
            throw new CreateFailureException();
        }

        long date = Instant.now().getEpochSecond();
        String tags = convertTags(blogDTO.getTags());
        ArticleDTO articleDTO = articleManager.createOrGet(blogDTO.getContent());

        blogEntity = new BlogEntity();
        blogEntity.setId(IdUtil.nextId());
        blogEntity.setTitleHash(titleHash);
        blogEntity.setTitle(blogDTO.getTitle());
        blogEntity.setKeywords(blogDTO.getKeywords());
        blogEntity.setDescription(blogDTO.getDescription());
        blogEntity.setTags(tags);
        blogEntity.setStatus(StatusEnum.UNPUBLISHED.getCode());
        blogEntity.setCreatedAt(date);
        blogEntity.setUpdatedAt(date);
        blogEntity.setArticleId(articleDTO.getId());

        blogRepository.save(blogEntity);

        return BlogDTO.from(blogEntity);
    }

    @Override
    @Transactional
    public BlogDTO update(BlogDTO blogDTO) {

        String titleHash = HashUtil.sha256(blogDTO.getTitle());

        // 根据博文标题，校验是否有重复博文(除自身以外)
        BlogEntity blogEntity = blogRepository.findByTitleHash(titleHash);
        if (blogEntity != null && blogEntity.getId() != blogDTO.getBlogId()) {
            throw new UpdateFailureException();
        }

        Optional<BlogEntity> entity = blogRepository.findById(blogDTO.getBlogId());
        blogEntity = entity.orElseThrow(UpdateFailureException::new);

        long date = Instant.now().getEpochSecond();
        String tags = convertTags(blogDTO.getTags());
        ArticleDTO articleDTO = articleManager.createOrGet(blogDTO.getContent());

        blogEntity.setTitleHash(titleHash);
        blogEntity.setTitle(blogDTO.getTitle());
        blogEntity.setKeywords(blogDTO.getKeywords());
        blogEntity.setDescription(blogDTO.getDescription());
        blogEntity.setTags(tags);
        blogEntity.setStatus(StatusEnum.PUBLISHED.getCode());
        blogEntity.setUpdatedAt(date);
        blogEntity.setPublishedAt(date);
        blogEntity.setArticleId(articleDTO.getId());

        blogRepository.save(blogEntity);

        return BlogDTO.from(blogEntity);
    }

    @Override
    @Transactional
    public void delete(Long blogId) {

        long updatedAt = Instant.now().getEpochSecond();
        int updateCount = blogRepository.updateStatus(blogId, StatusEnum.LOCKED.getCode(), updatedAt);

        if (updateCount != 1) {
            throw new DeteleFailureException();
        }
    }

    /**
     * tags 列表转换为指定分隔符分隔的字符串
     *
     * @param tags tags list
     * @return tags string
     */
    private String convertTags(List<String> tags) {
        return tags.stream()
                .map(String::trim)
                .collect(Collectors.joining(BlogDTO.TAG_SEPARATOR));
    }
}
