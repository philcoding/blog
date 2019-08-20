package com.philcoding.blog.manager;

import com.philcoding.blog.model.article.ArticleDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ArticleManagerTest {

    @Autowired
    ArticleManager articleManager;

    @Test
    public void createOrGet() {

        String content = "如果有值，则对其执行调用mapping。";

        ArticleDTO article = articleManager.createOrGet(content);

        Assert.assertNotNull("创建失败", article);
        Assert.assertNotNull("创建失败", article.getId());
    }
}