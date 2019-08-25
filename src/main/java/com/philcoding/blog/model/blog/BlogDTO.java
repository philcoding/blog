package com.philcoding.blog.model.blog;

import com.philcoding.blog.entity.BlogEntity;
import com.philcoding.blog.util.DateTimeUtil;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlogDTO {

    /**
     * 多标签间分隔符
     */
    public static final String TAG_SEPARATOR = ",";

    /**
     * 博文ID
     */
    private Long blogId;

    /**
     * 标题
     */
    private String title;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 摘要
     */
    private String description;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 标签列表
     */
    private List<String> tags;

    /**
     * 博文状态
     * 0 未发布，1 已发布，2 已锁定
     */
    private int status;

    /**
     * 发布时间
     */
    private LocalDateTime publishedAt;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    public static BlogDTO getInstance() {
        return new BlogDTO();
    }

    public static BlogDTO empty() {
        return BlogDTO.getInstance();
    }

    public static BlogDTO from(BlogEntity blogEntity) {

        List<String> tags = StringUtils.hasText(blogEntity.getTags())
                ? Arrays.asList(blogEntity.getTags().split(TAG_SEPARATOR))
                : new ArrayList<>();

        BlogDTO blogDTO = getInstance();
        blogDTO.setBlogId(blogEntity.getId());
        blogDTO.setTitle(blogEntity.getTitle());
        blogDTO.setKeywords(blogEntity.getKeywords());
        blogDTO.setDescription(blogEntity.getDescription());
        blogDTO.setStatus(blogEntity.getStatus());
        blogDTO.setTags(tags);

        if (blogEntity.getCreatedAt() > 0) {
            blogDTO.setCreatedAt(DateTimeUtil.Of(blogEntity.getCreatedAt()));
        }

        if (blogEntity.getUpdatedAt() > 0) {
            blogDTO.setUpdatedAt(DateTimeUtil.Of(blogEntity.getUpdatedAt()));
        }

        if (blogEntity.getPublishedAt() > 0) {
            blogDTO.setPublishedAt(DateTimeUtil.Of(blogEntity.getPublishedAt()));
        }

        return blogDTO;
    }

    public static BlogDTO from(CreateQuery createQuery) {

        List<String> tags = StringUtils.hasText(createQuery.getTags())
                ? Arrays.asList(createQuery.getTags().split(TAG_SEPARATOR))
                : new ArrayList<>();

        BlogDTO blogDTO = getInstance();
        blogDTO.setTitle(StringUtils.trimWhitespace(createQuery.getTitle()));
        blogDTO.setKeywords(StringUtils.trimWhitespace(createQuery.getKeywords()));
        blogDTO.setDescription(StringUtils.trimWhitespace(createQuery.getDescription()));
        blogDTO.setContent(createQuery.getContent());
        blogDTO.setTags(tags);

        return blogDTO;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "BlogDTO{" +
                "blogId=" + blogId +
                ", title='" + title + '\'' +
                ", keywords='" + keywords + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", tags=" + tags +
                ", status=" + status +
                ", publishedAt=" + publishedAt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
