package com.philcoding.blog.model.mapper;

import com.philcoding.blog.entity.ArticleEntity;
import com.philcoding.blog.model.dto.ArticleDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    ArticleDTO from(ArticleEntity article);
}
