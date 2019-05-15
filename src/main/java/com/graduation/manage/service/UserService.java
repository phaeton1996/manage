package com.graduation.manage.service;

import com.graduation.manage.dao.UserDao;
import com.graduation.manage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Integer login(String accont,String password){
        return userDao.login(accont,password);
    }

    public User getByAccount(String account){
        return userDao.getByAccount(account);
    }

    public void setLoginSession(User user, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
    }



}
