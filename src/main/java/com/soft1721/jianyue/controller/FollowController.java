package com.soft1721.jianyue.controller;

import com.soft1721.jianyue.entity.Follow;
import com.soft1721.jianyue.entity.vo.FollowVO;
import com.soft1721.jianyue.service.FollowService;
import com.soft1721.jianyue.util.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/follow")
public class FollowController {
    @Resource
    private FollowService followService;


    @PostMapping("/add")
    public ResponseResult followUser(@RequestParam("fromUId") int fromUId, @RequestParam("toUId") int toUId) {
        Follow follow = new Follow();
        follow.setFromUId(fromUId);
        follow.setToUId(toUId);
        followService.insertFollow(follow);
        return ResponseResult.success();
    }

    @PostMapping("/cancel")
    public ResponseResult cancelFollow(@RequestParam("fromUId") int fromUId, @RequestParam("toUId") int toUId) {
        followService.deleteFollow(fromUId, toUId);
        return ResponseResult.success();
    }

    @GetMapping(value = "/list")
    public ResponseResult getFollowByUId(@RequestParam("fromUId") int fromUId){
        List<FollowVO> follows = followService.getFollowsByUId(fromUId);
        return ResponseResult.success(follows);
    }
}