package com.graduation.manage.dao;

import com.graduation.manage.entity.Goods;
import org.apache.ibatis.annotations.*;

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

    @Select({"SELECT * FROM goods where id = #{id}"})
    Goods getById(@Param("id") int id);

//    "imgUrl = #{goods.imgUrl}, " +
    @Update("UPDATE goods SET " +
            "name = #{goods.name}, " +
            "seckill_price = #{goods.seckillPrice}, " +
            "stocks = #{goods.stocks}, " +

            "start_time = #{goods.startTime}, " +
            "end_time = #{goods.endTime}, " +
            "descr = #{goods.descr} " +
            "WHERE id = #{goods.id}")
    int modify(@Param("goods")Goods goods);

    @Update("UPDATE goods SET " +
            "status = status * (-1) " +
            "WHERE id = #{id}")
    int sellout(@Param("id")int id);

    @Delete("DELETE FROM goods " +
            "WHERE id = #{id}")
    int delete(@Param("id")int id);
}
