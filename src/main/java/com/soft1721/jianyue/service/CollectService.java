package com.soft1721.jianyue.service;

import com.soft1721.jianyue.entity.Collect;
import com.soft1721.jianyue.entity.vo.CollectVO;
import java.util.List;

public interface CollectService {
    Collect getCollect(int fromUId, int toAId);

    void insertCollect(Collect collect);

    void deleteCollect(int fromUId, int toAId);

    List<CollectVO> getCollectByUId(int fromUId);
}
