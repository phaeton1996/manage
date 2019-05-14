package com.graduation.manage.ExceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    /* 服务器异常或者是需要跳转的异常会被捕获 */
    @ExceptionHandler(value=RuntimeException.class)
    public ModelAndView ServerExceptionHandler(HttpServletRequest request, Exception e){
        e.printStackTrace();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error");
        mav.addObject("msg",e.getMessage());
        return mav;
    }
}
