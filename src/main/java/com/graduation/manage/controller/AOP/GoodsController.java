package com.graduation.manage.controller.AOP;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduation.manage.entity.Goods;
import com.graduation.manage.service.GoodsService;
import com.graduation.manage.vo.GoodsVo;
import com.graduation.manage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/goodslist")
    public String toGoodsList(ModelMap modelMap, GoodsVo goodsVo){
        PageHelper.startPage(goodsVo.getPageNum(),goodsVo.getPageSize());
        List<Goods> goodsList = goodsService.getGoodsList(goodsVo.getKeywords());
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        modelMap.addAttribute("goodsList",goodsList);
        modelMap.addAttribute("pageInfo",pageInfo);
        return "goodslist";
    }

    @RequestMapping("/goods")
    public String toGoodsList(HttpServletRequest request, ModelMap modelMap){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        modelMap.addAttribute("user",user);
        return "goods";
    }
}
