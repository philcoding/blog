package com.philcoding.blog.service.impl;

import com.philcoding.blog.entity.BlogEntity;
import com.philcoding.blog.enums.StatusEnum;
import com.philcoding.blog.manager.ArticleManager;
import com.philcoding.blog.model.article.ArticleDTO;
import com.philcoding.blog.model.blog.BlogDTO;
import com.philcoding.blog.repository.BlogRepository;
import com.philcoding.blog.service.BlogService;
import com.philcoding.blog.util.HashUtil;
import com.philcoding.blog.util.IdUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    private final ArticleManager articleManager;

    public BlogServiceImpl(BlogRepository blogRepository,
                           ArticleManager articleManager) {
        this.blogRepository = blogRepository;
        this.articleManager = articleManager;
    }

    @Transactional
    @Override
    public BlogDTO create(BlogDTO blogDTO) {

        ArticleDTO articleDTO = articleManager.createOrGet(blogDTO.getContent());

        long articleId = articleDTO.getId();
        long blogId = IdUtil.nextId();
        long date = System.currentTimeMillis();
        String title = blogDTO.getTitle();
        String titleHash = HashUtil.sha256(title);

        // TODO: 根据博文标题，校验是否有重复博文

        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setId(blogId);
        blogEntity.setTitle(title);
        blogEntity.setTitleHash(titleHash);
        blogEntity.setKeywords(blogDTO.getKeywords());
        blogEntity.setDescription(blogDTO.getDescription());
        blogEntity.setTags(String.join(blogDTO.TAG_SEPARATOR, blogDTO.getTags()));
        blogEntity.setStatus(StatusEnum.UNPUBLISHED.getCode());
        blogEntity.setCreatedAt(date);
        blogEntity.setUpdatedAt(date);
        blogEntity.setPublishedAt(0L);

        blogEntity.setArticleId(articleId);

        blogRepository.save(blogEntity);

        return BlogDTO.from(blogEntity, articleDTO);
    }

    @Override
    public BlogDTO update(BlogDTO blogDTO) {
        return null;
    }

    @Override
    public BlogDTO delete(Long blogId) {
        return null;
    }
}
