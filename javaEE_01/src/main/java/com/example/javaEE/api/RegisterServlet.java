package com.example.javaEE.api;

import com.example.javaEE.FactoryBean;
import com.example.javaEE.Service.UserService;
import com.example.javaEE.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册
 *
 * @Auther: hzy
 * @Date: 2021/11/8 22:17
 * @Description:
 */

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

    private UserService userService = FactoryBean.getUserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean register = userService.register(new User(username, password));
        System.out.println("register = " + register);
        if (register)
            response.sendRedirect("/javaEE_01/Page/service/registerSucceed.jsp");
        else
            response.sendRedirect("/javaEE_01/Page/service/registerfail.jsp");
    }
}
