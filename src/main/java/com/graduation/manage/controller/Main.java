package com.graduation.manage.controller;

import com.graduation.manage.entity.User;
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
    public String toLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(String account, String password, HttpServletRequest request) {
        if (account == null || password == null || "".equals(account) && "".equals(password)) {
            return Result.error("参数错误");
        }
        User user = userService.getByAccount(account);
        if (user == null) {
            return Result.error("此账号不存在");
        }
        if (!user.getPassword().equals(MD5Util.MD5Hex(password))) {
            return Result.error("密码错误");
        }
        userService.setLoginSession(user, request);
        return Result.success();
    }

}
