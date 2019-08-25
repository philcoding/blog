package com.philcoding.blog.repository;

import com.philcoding.blog.entity.BlogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long> {

    BlogEntity findByTitleHash(String titleHash);

    Page<BlogEntity> findAllByStatus(int status, Pageable pageable);

    @Modifying
    @Query("UPDATE BlogEntity b SET b.status =:status, updated_at =:updatedAt WHERE b.id =:blogId")
    int lock(long blogId, int status, long updatedAt);

    @Modifying
    @Query("UPDATE BlogEntity b " +
            "SET b.status =:status, updated_at =:publishedAt, published_at =:publishedAt " +
            "WHERE b.id =:blogId")
    int publish(long blogId, int status, long publishedAt);

    @Modifying
    @Query("UPDATE BlogEntity b " +
            "SET b.status =:status, updated_at =:updatedAt, published_at = 0 " +
            "WHERE b.id =:blogId")
    int unpublish(long blogId, int status, long updatedAt);
}
