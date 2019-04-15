package com.soft1721.jianyue.service;

import com.soft1721.jianyue.entity.Comment;
import com.soft1721.jianyue.entity.vo.CommentVO;
import java.util.List;

public interface CommentService {
    List<CommentVO> selectCommentsByAId(int aId);
    void addComment(Comment comment);
}