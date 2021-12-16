package com.example.javaEE_02.api.Servlet;

import com.example.javaEE_02.api.service.Impl.UserServiceImpl;
import com.example.javaEE_02.api.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            userService.login(req, resp);
        } catch (Exception e) {
            System.err.println("error:  " + e);
        }
    }
}
