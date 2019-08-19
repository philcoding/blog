package com.philcoding.blog.model.dto;

public class ArticleDTO {

    /**
     * 文章ID
     */
    private Long id;

    /**
     * 文章内容
     */
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
