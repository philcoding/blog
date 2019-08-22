package com.philcoding.blog.service;

import com.philcoding.blog.exception.CreateFailureException;
import com.philcoding.blog.exception.DeteleFailureException;
import com.philcoding.blog.exception.UpdateFailureException;
import com.philcoding.blog.model.blog.BlogDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceTest {

    @Autowired
    private BlogService blogService;

    @Test
    public void create() {

        BlogDTO blogDTO = BlogDTO.getInstance();

        List<String> tags = Arrays.asList("test,blog,dto".split(BlogDTO.TAG_SEPARATOR));

        blogDTO.setTitle(StringUtils.trimWhitespace("create blog0001"));
        blogDTO.setKeywords(StringUtils.trimWhitespace("create blog"));
        blogDTO.setDescription(StringUtils.trimWhitespace("create blog"));
        blogDTO.setContent("create blog");
        blogDTO.setTags(tags);

        try {
            blogDTO = blogService.create(blogDTO);

            Assert.assertEquals("新增博文失败", Optional.of(0L), Optional.of(blogDTO.getBlogId()));

        } catch (Exception e) {
            Assert.assertTrue("新增博文失败", e instanceof CreateFailureException);
        }
    }

    @Test
    public void update() {

        BlogDTO blogDTO = BlogDTO.getInstance();

        List<String> tags = Arrays.asList("test,blog,dto".split(BlogDTO.TAG_SEPARATOR));

        blogDTO.setBlogId(1299870459625536L);
        blogDTO.setTitle(StringUtils.trimWhitespace("update blog0001"));
        blogDTO.setKeywords(StringUtils.trimWhitespace("update blog"));
        blogDTO.setDescription(StringUtils.trimWhitespace("update blog"));
        blogDTO.setContent("update blog");
        blogDTO.setTags(tags);

        try {
            blogService.update(blogDTO);

        } catch (Exception e) {
            Assert.assertTrue("更新博文失败", e instanceof UpdateFailureException);
        }
    }

    @Test
    public void delete() {
        long blogId = 1299712260964384L;
        try {
            blogService.delete(blogId);
        } catch (Exception e) {
            Assert.assertTrue("删除失败", e instanceof DeteleFailureException);
        }
    }
}