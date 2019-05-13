package com.graduation.manage.dao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {

    @RequestMapping("goods")
    public String goods(){
        return "goods";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("order")
    public String order(){
        return "order";
    }

    @RequestMapping("user")
    public String user(){
        return "user";
    }
}
