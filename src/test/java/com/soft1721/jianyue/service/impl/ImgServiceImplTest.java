package com.soft1721.jianyue.service.impl;

import com.soft1721.jianyue.entity.Img;
import com.soft1721.jianyue.mapper.ImgMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImgServiceImplTest {
    @Resource
    private ImgMapper imgMapper;

    @Test
    public void insertImg() {
        Img img = new Img();
        img.setaId(4);
        img.setImgs("https://cdn2.jianshu.io/assets/web/misc-logo-805143ddec2e594416e891df316a73a7.png");
        imgMapper.insertImg(img);
    }
}