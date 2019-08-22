package com.philcoding.blog.service;

import com.philcoding.blog.model.blog.BlogDTO;

public interface BlogService {

    BlogDTO create(BlogDTO blogDTO);

    BlogDTO update(BlogDTO blogDTO);

    void delete(Long blogId);
}
