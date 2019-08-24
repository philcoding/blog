package com.philcoding.blog.model.pageable;

import org.springframework.data.domain.Page;

public class PageDTO {

    /**
     * 查询页，从 0 开始
     */
    private Integer page;

    /**
     * 每页的期望行数
     */
    private Integer size;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 总条数
     */
    private Long total;

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

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public static PageDTO getInstance() {
        return new PageDTO();
    }

    public static PageDTO of(PageQuery pageQuery) {

        PageDTO pageDTO = getInstance();

        pageDTO.setPage(pageQuery.getPage());
        pageDTO.setSize(pageQuery.getSize());

        return pageDTO;
    }

    public static PageDTO of(Page page) {

        PageDTO pageDTO = getInstance();

        pageDTO.setSize(page.getSize());
        pageDTO.setTotal(page.getTotalElements());

        pageDTO.setPage(page.getNumber());
        pageDTO.setTotalPage(page.getTotalPages());

        return pageDTO;
    }

    @Override
    public String toString() {
        return "PageableQuery{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }
}
