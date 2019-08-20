package com.philcoding.blog.manager;

import com.philcoding.blog.model.article.ArticleDTO;

public interface ArticleManager {

    ArticleDTO createOrGet(String content);
}
