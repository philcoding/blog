package com.philcoding.blog.model.blog;

public class BlogDetailVO extends BlogVO {

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

    public static BlogDetailVO from(BlogDTO blogDTO) {

        BlogDetailVO blogDetailVO = new BlogDetailVO();

        blogDetailVO.setBlogId(blogDTO.getBlogId());
        blogDetailVO.setTitle(blogDTO.getTitle());
        blogDetailVO.setKeywords(blogDTO.getKeywords());
        blogDetailVO.setDescription(blogDTO.getDescription());
        blogDetailVO.setContent(blogDTO.getContent());
        blogDetailVO.setTags(blogDTO.getTags());
        blogDetailVO.setDate(blogDTO.getPublishedAt());

        return blogDetailVO;
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
}
