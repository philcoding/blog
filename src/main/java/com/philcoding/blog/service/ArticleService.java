package com.philcoding.blog.service;

import com.philcoding.blog.model.dto.ArticleDTO;

public interface ArticleService {

    ArticleDTO create(String content);
}
