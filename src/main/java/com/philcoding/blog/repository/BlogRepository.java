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
    int updateStatus(long blogId, int status, long updatedAt);
}
