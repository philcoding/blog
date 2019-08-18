package com.philcoding.blog.service;

import com.philcoding.blog.entity.ArticleEntity;

public interface ArticleService {

    ArticleEntity create(String content);
}
