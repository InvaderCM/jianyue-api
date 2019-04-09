package com.soft1721.jianyue.controller;

import com.soft1721.jianyue.entity.Img;
import com.soft1721.jianyue.entity.vo.ArticleVO;
import com.soft1721.jianyue.entity.vo.CommentVO;
import com.soft1721.jianyue.service.ArticleService;
import com.soft1721.jianyue.service.CommentService;
import com.soft1721.jianyue.util.ResponseResult;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.*;
@RestController
@RequestMapping(value = "/api/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @Resource
    private CommentService commentService;

    @GetMapping(value = "/list")
    public ResponseResult getAll() {
        List<ArticleVO> articleList = articleService.selectAll();
        return ResponseResult.success(articleList);
    }

    @GetMapping(value = "/{aId}")
    public ResponseResult getArticleById(@PathVariable("aId") int aId) {
        ArticleVO article = articleService.getArticleById(aId);
        List<CommentVO> comments = commentService.selectCommentsByAId(aId);
        List<Img> imgs = articleService.selectImgByaId(aId);
        Map<String, Object> map = new HashMap<>();
        map.put("article", article);
        map.put("comments", comments);
        map.put("imgs", imgs);
        return ResponseResult.success(map);
    }
}