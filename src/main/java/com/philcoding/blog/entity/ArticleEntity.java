package com.philcoding.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class ArticleEntity {

    /**
     * 文章ID
     */
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    /**
     * 内容详情
     */
    @Column(name = "content", nullable = false)
    private String content;

    /**
     * 内容Hash，用于校验文章内容是否重复
     */
    @Column(name = "content_hash", nullable = false, length = 64, unique = true)
    private String contentHash;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentHash() {
        return contentHash;
    }

    public void setContentHash(String contentHash) {
        this.contentHash = contentHash;
    }

    @Override
    public String toString() {
        return "ArticleEntity{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", contentHash=" + contentHash +
                '}';
    }
}
