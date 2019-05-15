package com.graduation.manage.dao;

import com.graduation.manage.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsDao {

    @Select("SELECT g.*,c.name AS 'category_name' FROM goods g LEFT JOIN goods_category c ON g.category_id = c.id " +
            "ORDER BY start_time")
    List<Goods> getGoodsList();
}
