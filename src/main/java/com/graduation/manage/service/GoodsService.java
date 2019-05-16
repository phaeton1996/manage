package com.graduation.manage.service;

import com.graduation.manage.dao.GoodsDao;
import com.graduation.manage.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    public List<Goods> getGoodsList(String keywords){
        return goodsDao.getGoodsList(keywords);
    }

}
