package com.graduation.manage.dao;

import com.graduation.manage.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsDao {

    @Select({"<script>",
            "SELECT g.*,c.name AS 'category_name' FROM goods g ,goods_category c where g.category_id = c.id ",
            "<when test='keywords!=null'>",
            "and g.name like CONCAT('%',#{keywords},'%') ",
            "</when>",
            "ORDER BY start_time",
            "</script>"})
    List<Goods> getGoodsList(@Param("keywords") String keywords);
}
