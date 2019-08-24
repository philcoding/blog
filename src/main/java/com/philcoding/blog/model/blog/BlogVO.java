package com.philcoding.blog.model.blog;

import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

abstract class BlogVO {

    /**
     * 博文ID
     */
    private Long blogId;

    /**
     * 标题
     */
    private String title;

    /**
     * 标签列表
     */
    private String tags;

    /**
     * 发布时间
     */
    private String date;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(List<String> tagList) {
        if (!CollectionUtils.isEmpty(tagList)) {
            this.tags = String.join(BlogDTO.TAG_SEPARATOR, tagList);
        } else {
            this.tags = "";
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(LocalDateTime dateTime) {
        if (dateTime != null) {
            this.date = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
        } else {
            this.date = "";
        }
    }

    @Override
    public String toString() {
        return "BlogVO{" +
                "blogId=" + blogId +
                ", title='" + title + '\'' +
                ", tags='" + tags + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
