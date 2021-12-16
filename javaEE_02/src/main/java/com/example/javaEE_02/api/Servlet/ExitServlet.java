package com.example.javaEE_02.api.Servlet;

import com.example.javaEE_02.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 退出登录
 */
@WebServlet("/exit")
public class ExitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("User");
        if (user != null) {
            session.removeAttribute("User");
            System.out.println("退出成功");
        } else {
            System.out.println("当前未在线");
        }
    }


}
