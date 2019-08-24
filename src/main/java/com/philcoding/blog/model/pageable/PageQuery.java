package com.philcoding.blog.model.pageable;

import javax.validation.constraints.NotNull;

public class PageQuery {

    /**
     * 查询页，从 0 开始
     */
    @NotNull
    private Integer page;

    /**
     * 每页的期望行数
     */
    @NotNull
    private Integer size;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PageableQuery{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }
}
