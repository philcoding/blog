package com.philcoding.blog.repository;

import com.philcoding.blog.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    ArticleEntity findByContentHash(String contentHash);

}
