package com.philcoding.blog.service.impl;

import com.philcoding.blog.entity.ArticleEntity;
import com.philcoding.blog.model.dto.ArticleDTO;
import com.philcoding.blog.model.mapper.ArticleMapper;
import com.philcoding.blog.repository.ArticleRepository;
import com.philcoding.blog.service.ArticleService;
import com.philcoding.blog.util.HashUtil;
import com.philcoding.blog.util.IdUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    public ArticleServiceImpl(ArticleRepository articleRepository,
                              ArticleMapper articleMapper) {

        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }

    @Override
    @Transactional
    public ArticleDTO create(String content) {

        if (!StringUtils.hasText(content)) {
            return null;
        }

        String hashContent = HashUtil.sha256(content);

        ArticleEntity articleEntity = articleRepository.findByContentHash(hashContent);
        if (articleEntity == null) {

            long articleId = IdUtil.nextId();

            articleEntity = new ArticleEntity();
            articleEntity.setContentHash(hashContent);
            articleEntity.setId(articleId);
            articleEntity.setContent(content);

            articleRepository.save(articleEntity);
        }

        return articleMapper.from(articleEntity);
    }
}
