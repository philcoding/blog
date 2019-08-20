package com.philcoding.blog.manager.impl;

import com.philcoding.blog.entity.ArticleEntity;
import com.philcoding.blog.manager.ArticleManager;
import com.philcoding.blog.model.article.ArticleDTO;
import com.philcoding.blog.model.article.ArticleDTOMapper;
import com.philcoding.blog.repository.ArticleRepository;
import com.philcoding.blog.util.HashUtil;
import com.philcoding.blog.util.IdUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ArticleManagerImpl implements ArticleManager {

    private final ArticleRepository articleRepository;
    private final ArticleDTOMapper articleDTOMapper;

    public ArticleManagerImpl(ArticleRepository articleRepository,
                              ArticleDTOMapper articleDTOMapper) {

        this.articleRepository = articleRepository;
        this.articleDTOMapper = articleDTOMapper;
    }

    @Override
    public ArticleDTO createOrGet(String content) {

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

        return articleDTOMapper.from(articleEntity);
    }
}
