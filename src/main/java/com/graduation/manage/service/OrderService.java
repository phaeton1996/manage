package com.graduation.manage.service;

import com.graduation.manage.dao.OrderDao;
import com.graduation.manage.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public List<Order> getOrderListByUsername(String keywords){
        return orderDao.getOrderListByUsername(keywords);
    }

    public List<Order> getOrderListByGoodsname(String keywords){
        return orderDao.getOrderListByGoodsname(keywords);
    }
}
