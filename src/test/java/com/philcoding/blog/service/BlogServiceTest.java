package com.philcoding.blog.service;

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

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceTest {

    @Autowired
    private BlogService blogService;

    @Test
    public void create() {

        BlogDTO blogDTO = BlogDTO.getInstance();

        List<String> tags = Arrays.asList("test|blog|dto".split(blogDTO.TAG_SEPARATOR));

        blogDTO.setTitle(StringUtils.trimWhitespace("test blog"));
        blogDTO.setKeywords(StringUtils.trimWhitespace("test blog"));
        blogDTO.setDescription(StringUtils.trimWhitespace("test blog"));
        blogDTO.setContent("test blog");
        blogDTO.setTags(tags);

        Assert.assertNotNull("新增博文失败", blogService.create(blogDTO));
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}