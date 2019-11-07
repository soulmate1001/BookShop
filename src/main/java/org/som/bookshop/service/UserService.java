package org.som.bookshop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.som.bookshop.entity.User;
import org.som.bookshop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @outhor soulmate
 * @create 2019/11/7-11:47
 * @Description:用户业务层
 */
@Service
public class UserService extends ServiceImpl<UserMapper,User> {
    //把mapper装配进来
    @Autowired(required = false)
    private UserMapper userMapper;
    /**
     * 验证用户的存在性
     */
    public String checkUser(String username){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        User user = userMapper.selectOne(queryWrapper);

        //如果查询结果为空,则可以进行注册
        if(user == null){
            return "101";//用户不存在,可以进行注册
        }else{
            return "102";//用户已存在,不能进行注册
        }
    }

    /**
     * 登录验证
     * @param loginUser
     * @return
     */
    public String loginCheck(User loginUser, HttpSession session){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",loginUser.getUsername());
        User user = userMapper.selectOne(queryWrapper);

        if(null == user){
            return "101";  //表示用户不存在
        }else{  //表示存在然后校验密码
            if(loginUser.getPassword().equals(user.getPassword())){
                session.setAttribute("user",user);
                return "100";  //密码正确
            }else{
                return "102";  //密码错误
            }
        }

    }

}
