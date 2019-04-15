package com.soft1721.jianyue.service;

import com.soft1721.jianyue.entity.Article;
import com.soft1721.jianyue.entity.Img;
import com.soft1721.jianyue.entity.vo.ArticleVO;

import java.util.List;

public interface ArticleService {
    /*查询所有*/
    List<ArticleVO> selectAll();

    /*通过文章id查询文章信息*/
    ArticleVO getArticleById(int aId);

    /*通过文章aid查询文章中的图片*/
    List<Img> selectImgByaId(int aId);

    /*新增文章*/
    void insertArticle(Article article);

    /*通过uid查询所有的文章*/
    List<Article> selectByuId(int uId);
}