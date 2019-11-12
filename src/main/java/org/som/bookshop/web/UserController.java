package org.som.bookshop.web;

import org.som.bookshop.entity.User;
import org.som.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @outhor soulmate
 * @create 2019/11/7-11:43
 * @Description:用户控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {
    //把service装配进来
    @Autowired
    private UserService userService;
    //验证用户名是否存在
    @ResponseBody
    @RequestMapping("/checkUserName")
    public String checkUserName(String username){
        return userService.checkUser(username);
    }

    //register用户注册
    @ResponseBody
    @RequestMapping("/register")
    public String register(User user){
        System.out.println(user);
        userService.save(user);
        return "success";
    }

    //login用户登录
    @ResponseBody
    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        return userService.loginCheck(user,session);
    }

    //用户注销
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        //直接让session失效即可
        session.invalidate();

        //重定向到首页
        return "redirect:/book/index";
    }

}
