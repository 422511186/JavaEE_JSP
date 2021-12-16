package com.example.javaEE_02.api.service;

import com.example.javaEE_02.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

    /**
     * 用户注册
     *
     * @param user
     */
    void register(User user) throws Exception;

    /**
     * 用户登录
     *
     * @param request
     * @param response
     * @throws Exception
     */
    void login(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * 记住密码
     *
     * @param request
     * @param response
     * @throws Exception
     */
    void RmPassword(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
