package com.philcoding.blog.service;

import com.philcoding.blog.model.dto.ArticleDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    public void testCreate() {

        String content = "如果有值，则对其执行调用mapping。";

        ArticleDTO article = articleService.create(content);

        Assert.assertNotNull("创建失败", article);
        Assert.assertNotNull("创建失败", article.getId());
    }
}
