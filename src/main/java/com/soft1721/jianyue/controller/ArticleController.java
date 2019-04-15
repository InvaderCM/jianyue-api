package com.soft1721.jianyue.controller;

import com.soft1721.jianyue.entity.Article;
import com.soft1721.jianyue.entity.Follow;
import com.soft1721.jianyue.entity.Img;
import com.soft1721.jianyue.entity.vo.ArticleVO;
import com.soft1721.jianyue.entity.vo.CommentVO;
import com.soft1721.jianyue.service.ArticleService;
import com.soft1721.jianyue.service.CommentService;
import com.soft1721.jianyue.service.FollowService;
import com.soft1721.jianyue.util.MsgConst;
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

    @Resource
    private FollowService followService;

    @GetMapping(value = "/list")
    public ResponseResult getAll() {
        List<ArticleVO> articleList = articleService.selectAll();
        return ResponseResult.success(articleList);
    }

    @GetMapping(value = "/{aId}")
    public ResponseResult getArticleById(@PathVariable("aId") int aId, @RequestParam("userId") int userId) {
        ArticleVO article = articleService.getArticleById(aId);
        int toUId = article.getuId();
        Map<String, Object> map = new HashMap<>();
        Follow follow = followService.getFollow(userId, toUId);
        if (follow != null) {
            map.put("followed", MsgConst.FOLLOWED);
        } else {
            map.put("followed", MsgConst.NO_FOLLOWED);
        }
        List<CommentVO> comments = commentService.selectCommentsByAId(aId);
        map.put("article", article);
        map.put("comments", comments);
        return ResponseResult.success(map);
    }

    @PostMapping("/add")
    public ResponseResult postArticle(@RequestParam("uId") int uId,
                                      @RequestParam("title") String title,
                                      @RequestParam("content") String content) {
        Article article = new Article();
        article.setUId(uId);
        article.setTitle(title);
        article.setContent(content);
        article.setCreateTime(new Date());
        articleService.insertArticle(article);
        //新增文章后，将获取到的自增主键返回给客户端，方便图片地址的写入
        return ResponseResult.success(article.getId());
    }

    @GetMapping("/getArticleByUID")
    public ResponseResult selectByuId(@RequestParam("uId") int uId) {
        List<Article> list = new ArrayList<>();
        list = articleService.selectByuId(uId);
        return ResponseResult.success(list);
    }
}