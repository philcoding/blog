package com.philcoding.blog.manager;

import com.philcoding.blog.model.article.ArticleDTO;

public interface ArticleManager {

    ArticleDTO findById(Long articleId);

    ArticleDTO createOrGet(String content);
}
