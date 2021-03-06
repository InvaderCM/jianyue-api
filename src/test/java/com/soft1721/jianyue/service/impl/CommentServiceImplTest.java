package com.soft1721.jianyue.service.impl;


import com.soft1721.jianyue.entity.Comment;
import com.soft1721.jianyue.entity.vo.CommentVO;
import com.soft1721.jianyue.mapper.CommentMapper;
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
public class CommentServiceImplTest {
    @Resource
    private CommentMapper commentMapper;

    @Test
    public void selectCommentsByAId() {
        List<CommentVO> list = new ArrayList<>();
        list = commentMapper.selectCommentsByAId(1);
        System.out.println(list);
    }

    @Test
    public void addComment() {
        Comment comment = new Comment();
        comment.setaId(3);
        comment.setuId(2);
        comment.setContent("1号用户的评论");
        comment.setCommentTime(new Date());
        commentMapper.insert(comment);
    }
}