package com.soft1721.jianyue.service.impl;

import com.soft1721.jianyue.entity.Article;
import com.soft1721.jianyue.entity.Img;
import com.soft1721.jianyue.entity.vo.ArticleVO;
import com.soft1721.jianyue.mapper.ArticleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {
    @Resource
    private ArticleMapper articleMapper;

    @Test
    public void selectAll() {
        /*List<ArticleVO> list = new ArrayList<>();
        list = articleMapper.selectAll();
        System.out.println(list);*/

        List<ArticleVO> articles = articleMapper.selectAll();
        for (ArticleVO articleVO : articles) {
            articleVO.setImgs(articleMapper.selectImgByaId(articleVO.getId()));
        }
        System.out.println(articles);
    }

    @Test
    public void getArticleById() {
        ArticleVO articleVO = articleMapper.getArticleById(1);
        List<Img> imgList = new ArrayList<>();
        imgList = articleMapper.selectImgByaId(1);
        articleVO.setImgs(imgList);
        System.out.println(articleVO);
    }

    @Test
    public void selectImgByaId() {
        List<Img> list = new ArrayList<>();
        list = articleMapper.selectImgByaId(1);
        System.out.println(list);
    }

    @Test
    public void insertArticle() {
        Article article = new Article();
        article.setTitle("hello");
        article.setUId(2);
        article.setContent("我的文章");
        article.setCreateTime(new Date());
        articleMapper.insertArticle(article);
    }
}