package com.example.javaEE.Service;

import com.example.javaEE.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: hzy
 * @Date: 2021/11/7 20:57
 * @Description:
 */

public interface UserService {

    //判断登录账户是否为正确的账户密码
    boolean doService(User user);


    //登录服务
    void Login(HttpServletRequest request, HttpServletResponse response) throws Exception;

    //注册
    boolean register(User user);

    //cookie实现账号密码自动填充功能
    void RmPassword(HttpServletRequest request, HttpServletResponse response) throws Exception;


}
