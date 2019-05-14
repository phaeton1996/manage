package com.graduation.manage.controller.AOP;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Dispatcher {

    @RequestMapping("/goods")
    public String toGoods(){
        return "goods";
    }
}
