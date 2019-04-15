package com.soft1721.jianyue.service.impl;

import com.soft1721.jianyue.entity.Collect;
import com.soft1721.jianyue.entity.vo.CollectVO;
import com.soft1721.jianyue.mapper.CollectMapper;
import com.soft1721.jianyue.service.CollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Resource
    private CollectMapper collectMapper;

    @Override
    public Collect getCollect(int fromUId, int toAId) {
        return collectMapper.getCollect(fromUId, toAId);
    }

    @Override
    public void insertCollect(Collect collect) {
        collectMapper.insertCollect(collect);
    }

    @Override
    public void deleteCollect(int fromUId, int toAId) {
        collectMapper.deleteCollect(fromUId, toAId);
    }

    @Override
    public List<CollectVO> getCollectByUId(int fromUId) {
        return collectMapper.getCollectByUId(fromUId);
    }
}
