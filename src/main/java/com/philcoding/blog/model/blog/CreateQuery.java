package com.philcoding.blog.model.blog;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateQuery {

    /**
     * 博文标题
     */
    @NotBlank(message = "标题不能为空")
    @Size(min = 4, max = 20, message = "标题的字数必须在4和20之间")
    private String title;

    /**
     * 博文内容
     */
    @NotBlank(message = "内容不能为空")
    @Size(min = 10, message = "内容的字数不能少于10")
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

    String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String getTags() {
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
