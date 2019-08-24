package com.philcoding.blog.model.blog;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BlogListVO extends BlogVO {

    public static List<BlogListVO> from(List<BlogDTO> blogList) {

        List<BlogListVO> blogListVOList = new ArrayList<>();

        if (!CollectionUtils.isEmpty(blogList)) {

            blogListVOList = blogList.stream()
                    .map(item -> {

                        BlogListVO blogListVO = new BlogListVO();
                        blogListVO.setBlogId(item.getBlogId());
                        blogListVO.setTitle(item.getTitle());
                        blogListVO.setTags(item.getTags());
                        blogListVO.setDate(item.getPublishedAt());

                        return blogListVO;

                    }).collect(Collectors.toList());
        }

        return blogListVOList;
    }
}
