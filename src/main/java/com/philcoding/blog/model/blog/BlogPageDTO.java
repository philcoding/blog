package com.philcoding.blog.model.blog;

import com.philcoding.blog.model.pageable.PageDTO;

import java.util.List;

public class BlogPageDTO {

    private List<BlogDTO> blogList;

    private PageDTO pageable;

    public List<BlogDTO> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<BlogDTO> blogList) {
        this.blogList = blogList;
    }

    public PageDTO getPageable() {
        return pageable;
    }

    public void setPageable(PageDTO pageable) {
        this.pageable = pageable;
    }

    @Override
    public String toString() {
        return "BlogPageDTO{" +
                "blogList=" + blogList +
                ", pageable=" + pageable +
                '}';
    }
}
