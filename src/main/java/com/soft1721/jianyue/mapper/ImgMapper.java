package com.soft1721.jianyue.mapper;

import com.soft1721.jianyue.entity.Img;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import javax.annotation.Resource;
public interface ImgMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "aId", column = "a_id"),
            @Result(property = "imgs", column = "img_url")
    })
    @Insert("INSERT INTO t_img(a_id,img_url) VALUES (#{aId},#{imgs})")
    void insertImg(Img img);
}
