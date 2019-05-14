package com.graduation.manage.service;

import com.graduation.manage.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Integer login(String accont,String password){
        return userDao.login(accont,password);
    }

    public void setLoginSession(String accont, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("account",accont);
    }



}
