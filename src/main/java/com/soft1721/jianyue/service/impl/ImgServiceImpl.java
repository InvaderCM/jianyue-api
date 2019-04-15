package com.soft1721.jianyue.service.impl;

import com.soft1721.jianyue.entity.Img;
import com.soft1721.jianyue.mapper.ImgMapper;
import com.soft1721.jianyue.service.ImgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ImgServiceImpl implements ImgService {
    @Resource
    private ImgMapper imgMapper;

    @Override
    public void insertImg(Img img) {
        imgMapper.insertImg(img);
    }
}
