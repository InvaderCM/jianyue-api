package com.soft1721.jianyue.service.impl;

import com.soft1721.jianyue.entity.Article;
import com.soft1721.jianyue.entity.Img;
import com.soft1721.jianyue.entity.vo.ArticleVO;
import com.soft1721.jianyue.mapper.ArticleMapper;
import com.soft1721.jianyue.service.ArticleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Override
    public List<ArticleVO> selectAll() {
        List<ArticleVO> articles = articleMapper.selectAll();
        for (ArticleVO articleVO : articles) {
            articleVO.setImgs(articleMapper.selectImgByaId(articleVO.getId()));
        }
        return articles;
    }

    @Override
    public ArticleVO getArticleById(int aId) {
        return articleMapper.getArticleById(aId);
    }

    @Override
    public List<Img> selectImgByaId(int aId) {
        return articleMapper.selectImgByaId(aId);
    }

    @Override
    public void insertArticle(Article article) {
        articleMapper.insertArticle(article);
    }

    @Override
    public List<Article> selectByuId(int uId) {
        List<Article> list = new ArrayList<>();
        list = articleMapper.selectByuId(uId);
        return list;
    }
}