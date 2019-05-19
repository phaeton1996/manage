package com.graduation.manage.controller.AOP;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduation.manage.entity.Order;
import com.graduation.manage.entity.User;
import com.graduation.manage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/orderlist")
    public String toGoodsList(ModelMap modelMap, Integer pageNum,String keywords,String condition) {
        PageHelper.startPage(pageNum, 5);
        List<Order> orderList = null;
        if (condition .equals("goods")){
            orderList = orderService.getOrderListByGoodsname(keywords);
        }else {
            orderList = orderService.getOrderListByUsername(keywords);
        }
        PageInfo<Order> pageInfo = new PageInfo<>(orderList);
        modelMap.addAttribute("orderList", orderList);
        modelMap.addAttribute("pageInfo", pageInfo);
        return "orderlist";
    }

    @RequestMapping("/order")
    public String toGoodsList(HttpServletRequest request, ModelMap modelMap) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        modelMap.addAttribute("user", user);
        return "order";
    }
}
