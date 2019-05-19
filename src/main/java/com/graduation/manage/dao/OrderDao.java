package com.graduation.manage.dao;

import com.graduation.manage.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderDao {

    @Select({"<script>",
            "select " ,
            "g.id,g.name,g.seckill_price,g.img_url," ,
            "a.addr,a.phone,a.user_name," ,
            "o.create_time,o.order_id,o.status " ,
            "from user_addr a,goods g,seckill_order o " ,
            "where " ,
            "o.goods_id = g.id and o.addr_id = a.id",
            "<when test='keywords!=null'>",
            "and a.user_name like CONCAT('%',#{keywords},'%') ",
            "</when>",
            "</script>"})
    @Results({
            @Result(property = "goods.id", column = "id"),
            @Result(property = "goods.seckillPrice", column = "seckill_price"),
            @Result(property = "goods.imgUrl", column = "img_url"),
            @Result(property = "goods.name", column = "name"),
            @Result(property = "addr.phone", column = "phone"),
            @Result(property = "addr.addr", column = "addr"),
            @Result(property = "addr.userName", column = "user_name"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "status", column = "status")
    })
    List<Order> getOrderListByUsername(@Param("keywords") String keywords);

    @Select({"<script>",
            "select " ,
            "g.id,g.name,g.seckill_price,g.img_url," ,
            "a.addr,a.phone,a.user_name," ,
            "o.create_time,o.order_id,o.status " ,
            "from user_addr a,goods g,seckill_order o " ,
            "where " ,
            "o.goods_id = g.id and o.addr_id = a.id",
            "<when test='keywords!=null'>",
            "and g.name like CONCAT('%',#{keywords},'%') ",
            "</when>",
            "</script>"})
    @Results({
            @Result(property = "goods.id", column = "id"),
            @Result(property = "goods.seckillPrice", column = "seckill_price"),
            @Result(property = "goods.imgUrl", column = "img_url"),
            @Result(property = "goods.name", column = "name"),
            @Result(property = "addr.phone", column = "phone"),
            @Result(property = "addr.addr", column = "addr"),
            @Result(property = "addr.userName", column = "user_name"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "status", column = "status")
    })
    List<Order> getOrderListByGoodsname(@Param("keywords") String keywords);
}
