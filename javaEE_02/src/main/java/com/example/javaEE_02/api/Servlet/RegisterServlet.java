package com.example.javaEE_02.api.Servlet;

import com.example.javaEE_02.api.service.Impl.UserServiceImpl;
import com.example.javaEE_02.api.service.UserService;
import com.example.javaEE_02.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setUser_account(username);
        user.setPassword(password);
        try {
            userService.register(user);
            resp.sendRedirect("/javaEE_02/page/login.jsp");
        } catch (Exception e) {
            System.err.println("error:  " + e);
            resp.sendRedirect("/javaEE_02/page/register.jsp");
        }

    }
}
