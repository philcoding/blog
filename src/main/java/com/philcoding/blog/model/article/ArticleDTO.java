package com.philcoding.blog.model.article;

import com.philcoding.blog.entity.ArticleEntity;

public class ArticleDTO {

    /**
     * 文章ID
     */
    private Long id;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 实例化对象
     *
     * @return ArticleDTO
     */
    public static ArticleDTO getInstance() {
        return new ArticleDTO();
    }

    public static ArticleDTO empty() {
        return ArticleDTO.getInstance();
    }

    /**
     * 实体 转换为 DTO
     *
     * @param articleEntity 文章实体
     * @return ArticleDTO
     */
    public static ArticleDTO from(ArticleEntity articleEntity) {
        if (articleEntity == null) {
            return null;
        }

        ArticleDTO articleDTO = getInstance();

        articleDTO.setId(articleEntity.getId());
        articleDTO.setContent(articleEntity.getContent());

        return articleDTO;
    }

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
