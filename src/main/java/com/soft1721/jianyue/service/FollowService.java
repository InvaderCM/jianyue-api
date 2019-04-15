package com.soft1721.jianyue.service;

import com.soft1721.jianyue.entity.Follow;
import com.soft1721.jianyue.entity.vo.FollowVO;

import java.util.List;

public interface FollowService {
    Follow getFollow(int fromUId, int toUId);

    List<FollowVO> getFollowsByUId(int fromUId);

    void insertFollow(Follow follow);

    void deleteFollow(int fromUId, int toUId);
}
