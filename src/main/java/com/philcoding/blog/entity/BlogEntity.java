package com.philcoding.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blog")
public class BlogEntity {

    /**
     * 博文
     */
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 标题
     */
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    /**
     * 关键字
     */
    @Column(name = "keywords", nullable = false, length = 100)
    private String keywords;

    /**
     * 摘要
     */
    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    /**
     * 标签列表
     */
    @Column(name = "tags", nullable = false, length = 100)
    private String tags;

    /**
     * 发布时间
     */
    @Column(name = "published_at", nullable = false)
    private Long publishedAt;

    /**
     * 创建时间
     */
    @Column(name = "created_at", nullable = false)
    private Long createdAt;

    /**
     * 更新时间
     */
    @Column(name = "updated_at", nullable = false)
    private Long updatedAt;

    /**
     * 文章ID
     */
    @Column(name = "article_id", nullable = false)
    private Long articleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Long getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Long publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    @Override
    public String toString() {
        return "BlogEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", keywords='" + keywords + '\'' +
                ", description='" + description + '\'' +
                ", tags='" + tags + '\'' +
                ", publishedAt=" + publishedAt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", articleId=" + articleId +
                '}';
    }
}
