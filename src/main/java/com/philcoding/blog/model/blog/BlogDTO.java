package com.philcoding.blog.model.blog;

import com.philcoding.blog.entity.ArticleEntity;
import com.philcoding.blog.entity.BlogEntity;
import com.philcoding.blog.model.article.ArticleDTO;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Date;
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
     * 发布时间
     */
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static BlogDTO getInstance(){
        return new BlogDTO();
    }

    public static BlogDTO from(BlogEntity blogEntity) {

        List<String> tags = Arrays.asList(blogEntity.getTags().split(TAG_SEPARATOR));

        BlogDTO blogDTO = getInstance();
        blogDTO.setBlogId(blogEntity.getId());
        blogDTO.setTitle(blogEntity.getTitle());
        blogDTO.setKeywords(blogEntity.getKeywords());
        blogDTO.setDescription(blogEntity.getDescription());
        blogDTO.setTags(tags);

        if (blogEntity.getPublishedAt() > 0) {
            blogDTO.setDate(new Date(blogEntity.getPublishedAt()));
        } else if (blogEntity.getUpdatedAt() > 0) {
            blogDTO.setDate(new Date(blogEntity.getUpdatedAt()));
        } else {
            blogDTO.setDate(new Date(blogEntity.getCreatedAt()));
        }

        return blogDTO;
    }

    public static BlogDTO from(CreateQuery createQuery) {

        List<String> tags = Arrays.asList(createQuery.getTags().split(TAG_SEPARATOR));

        BlogDTO blogDTO = getInstance();
        blogDTO.setTitle(StringUtils.trimWhitespace(createQuery.getTitle()));
        blogDTO.setKeywords(StringUtils.trimWhitespace(createQuery.getKeywords()));
        blogDTO.setDescription(StringUtils.trimWhitespace(createQuery.getDescription()));
        blogDTO.setContent(createQuery.getContent());
        blogDTO.setTags(tags);

        return blogDTO;
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
                ", date=" + date +
                '}';
    }
}
