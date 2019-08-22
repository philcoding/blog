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
    private long id;

    /**
     * 标题
     */
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    /**
     * 标题Hash，用于校验博文标题是否重复
     */
    @Column(name = "title_hash", nullable = false, length = 64, unique = true)
    private String titleHash;

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
     * 博文状态
     * 0 未发布，1 已发布，2 已锁定
     */
    @Column(name = "status", nullable = false)
    private int status;

    /**
     * 发布时间
     */
    @Column(name = "published_at", nullable = false)
    private long publishedAt;

    /**
     * 创建时间
     */
    @Column(name = "created_at", nullable = false)
    private long createdAt;

    /**
     * 更新时间
     */
    @Column(name = "updated_at", nullable = false)
    private long updatedAt;

    /**
     * 文章ID
     */
    @Column(name = "article_id", nullable = false)
    private long articleId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleHash() {
        return titleHash;
    }

    public void setTitleHash(String titleHash) {
        this.titleHash = titleHash;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(long publishedAt) {
        this.publishedAt = publishedAt;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    @Override
    public String toString() {
        return "BlogEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", titleHash='" + titleHash + '\'' +
                ", keywords='" + keywords + '\'' +
                ", description='" + description + '\'' +
                ", tags='" + tags + '\'' +
                ", status=" + status +
                ", publishedAt=" + publishedAt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", articleId=" + articleId +
                '}';
    }
}
