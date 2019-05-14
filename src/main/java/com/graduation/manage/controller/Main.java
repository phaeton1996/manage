package com.graduation.manage.controller;

import com.graduation.manage.service.UserService;
import com.graduation.manage.utils.MD5Util;
import com.graduation.manage.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Main {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginPage")
    public String toLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(String account, String password, HttpServletRequest request) {
        if (account == null || password == null || "".equals(account) && "".equals(password)) {
            return Result.error("参数错误");
        }
        int res = userService.login(account, MD5Util.MD5Hex(password));
        if (res != 1){
            return Result.error("账号密码错误");
        }
        userService.setLoginSession(account,request);
        return Result.success();
    }

}
