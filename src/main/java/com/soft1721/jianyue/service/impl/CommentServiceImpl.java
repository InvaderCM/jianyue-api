package com.soft1721.jianyue.service.impl;

import com.soft1721.jianyue.entity.vo.CommentVO;
import com.soft1721.jianyue.mapper.CommentMapper;
import com.soft1721.jianyue.service.CommentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<CommentVO> selectCommentsByAId(int aId) {
        return commentMapper.selectCommentsByAId(aId);
    }
}