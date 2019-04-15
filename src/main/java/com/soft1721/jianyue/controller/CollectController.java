package com.soft1721.jianyue.controller;


import com.soft1721.jianyue.entity.Collect;
import com.soft1721.jianyue.entity.vo.CollectVO;
import com.soft1721.jianyue.service.CollectService;
import com.soft1721.jianyue.util.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/collect")
public class CollectController {
    @Resource
    private CollectService collectService;

    @PostMapping("/add")
    public ResponseResult likeUser(@RequestParam("fromUId") int fromUId, @RequestParam("toAId") int toAId) {
        Collect collect = new Collect();
        collect.setFromUId(fromUId);
        collect.setToAId(toAId);
        collectService.insertCollect(collect);
        return ResponseResult.success();
    }

    @PostMapping("/cancel")
    public ResponseResult cancelFollow(@RequestParam("fromUId") int fromUId, @RequestParam("toAId") int toAId) {
        collectService.deleteCollect(fromUId, toAId);
        return ResponseResult.success();
    }

    @GetMapping("/collectlist")
    public ResponseResult getLikeByUId(@RequestParam("fromUId") Integer fromUId) {
        List<CollectVO> collectVOList = collectService.getCollectByUId(fromUId);
        return ResponseResult.success(collectVOList);
    }
}