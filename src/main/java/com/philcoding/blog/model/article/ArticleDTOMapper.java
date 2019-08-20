package com.philcoding.blog.model.article;

import com.philcoding.blog.entity.ArticleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleDTOMapper {

    ArticleDTO from(ArticleEntity article);
}
