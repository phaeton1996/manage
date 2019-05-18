package com.graduation.manage.controller.AOP;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduation.manage.entity.User;
import com.graduation.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/userlist")
    public String toUserList(ModelMap modelMap, Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<User> userList = userService.getGoodsList();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        modelMap.addAttribute("userList", userList);
        modelMap.addAttribute("pageInfo", pageInfo);
        return "userlist";
    }

    @RequestMapping("/user")
    public String userPage(HttpServletRequest request, ModelMap modelMap) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        modelMap.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/user/cstatus")
    @ResponseBody
    public Boolean cstatus(int id) {
        int res = userService.cstatus(id);
        return res == 1;
    }

    @GetMapping("/user/delete")
    @ResponseBody
    public Boolean delete(int id) {
        int res = userService.delete(id);
        return res == 1;
    }

}
