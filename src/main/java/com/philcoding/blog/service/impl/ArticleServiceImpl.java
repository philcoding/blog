package com.philcoding.blog.service.impl;

import com.philcoding.blog.entity.ArticleEntity;
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

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    @Transactional
    public ArticleEntity create(String content) {

        if (!StringUtils.hasText(content)) {
            // throw exception
            return null;
        }

        String hashContent = HashUtil.sha256(content);

        ArticleEntity article = articleRepository.findByContentHash(hashContent);
        if (article != null) {
            return article;
        }

        long articleId = IdUtil.nextId();

        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setContentHash(hashContent);
        articleEntity.setId(articleId);
        articleEntity.setContent(content);

        return articleRepository.save(articleEntity);
    }
}
