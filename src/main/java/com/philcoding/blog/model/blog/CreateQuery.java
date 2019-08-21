package com.philcoding.blog.model.blog;

import javax.validation.constraints.NotNull;

public class CreateQuery {

    /**
     * 博文标题
     */
    @NotNull
    private String title;

    /**
     * 博文内容
     */
    @NotNull
    private String content;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 摘要
     */
    private String description;

    /**
     * 标签列表
     */
    private String tags;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public String toString() {
        return "CreateQuery{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", keywords='" + keywords + '\'' +
                ", description='" + description + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }
}
