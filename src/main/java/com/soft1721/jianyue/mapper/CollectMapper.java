package com.soft1721.jianyue.mapper;

import com.soft1721.jianyue.entity.Collect;
import com.soft1721.jianyue.entity.vo.CollectVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CollectMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "fromUId", column = "from_uid"),
            @Result(property = "toAId", column = "to_aid")
    })
    @Select("SELECT * FROM t_collect WHERE from_uid = #{fromUId} AND to_aid = #{toAId} ")
    Collect getCollect(@Param("fromUId") int fromUId, @Param("toAId") int toAId);

    @Insert("INSERT INTO t_collect (from_uid,to_aid) VALUES (#{fromUId},#{toAId}) ")
    void insertCollect(Collect collect);

    @Delete("DELETE  FROM t_collect WHERE from_uid = #{fromUId} AND to_aid = #{toAId} ")
    void deleteCollect(@Param("fromUId") int fromUId, @Param("toAId") int toAId);

    @Results({
            @Result(column = "to_aid",property = "toAId"),
            @Result(column = "title",property = "title")
    })
    @Select("SELECT a.to_aid,b.title,b.create_time FROM t_collect a LEFT JOIN t_article b ON a.to_aid = b.id WHERE a.from_uid = #{fromUId}  " )
    List<CollectVO> getCollectByUId(Integer fromUId);
}
