package com.example.javaEE.api;

import com.example.javaEE.FactoryBean;
import com.example.javaEE.Service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录校验
 *
 * @Auther: hzy
 * @Date: 2021/10/7 17:35
 * @Description:
 */


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    private UserService userService = FactoryBean.getUserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {
            userService.Login(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

