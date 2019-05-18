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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/goodslist")
    public String toGoodsList(ModelMap modelMap, GoodsVo goodsVo) {
        PageHelper.startPage(goodsVo.getPageNum(), goodsVo.getPageSize());
        List<Goods> goodsList = goodsService.getGoodsList(goodsVo.getKeywords());
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        modelMap.addAttribute("goodsList", goodsList);
        modelMap.addAttribute("pageInfo", pageInfo);
        return "goodslist";
    }

    @RequestMapping("/goods")
    public String toGoodsList(HttpServletRequest request, ModelMap modelMap) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        modelMap.addAttribute("user", user);
        return "goods";
    }

    @RequestMapping("/goods/id/{id}")
    @ResponseBody
    public Goods getById(@PathVariable(value = "id") Integer id) {
        System.out.println(id);
        if (id != null) {
            return goodsService.getById(id);
        }
        return null;
    }

    @PostMapping("/goods/modify")
    @ResponseBody
    public Boolean modify(Goods goods) {
        int res = goodsService.modify(goods);
        return res == 1;
    }

    @GetMapping("/goods/sellout")
    @ResponseBody
    public Boolean sellout(int id) {
        int res = goodsService.sellout(id);
        return res == 1;
    }

    @GetMapping("/goods/delete")
    @ResponseBody
    public Boolean delete(int id) {
        int res = goodsService.delete(id);
        return res == 1;
    }
}
