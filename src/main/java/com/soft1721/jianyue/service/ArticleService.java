package com.soft1721.jianyue.service;

import com.soft1721.jianyue.entity.Img;
import com.soft1721.jianyue.entity.vo.ArticleVO;

import java.util.List;

public interface ArticleService {
    /*查询所有*/
    List<ArticleVO> selectAll();

    /*通过文章id查询文章信息*/
    ArticleVO getArticleById(int aId);

    List<Img> selectImgByaId(int aId);
}