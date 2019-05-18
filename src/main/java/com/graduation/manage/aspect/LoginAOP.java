package com.graduation.manage.aspect;

import com.graduation.manage.entity.User;
import com.graduation.manage.service.UserService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//@Component
//@Aspect
public class LoginAOP {
    /* 切点 */
    @Pointcut("execution(* com.graduation.manage.controller.AOP.*.*())")
    public void loginCheck() {
        System.out.println(".............................");
    }

    /* 前置通知 */
    @Before("loginCheck()")
    public void checkLoginStatus() {
        System.out.println("111");
        //获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null){
            throw new RuntimeException("请先登陆");
        }
    }
}
