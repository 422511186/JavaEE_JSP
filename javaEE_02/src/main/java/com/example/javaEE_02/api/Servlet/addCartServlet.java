package com.example.javaEE_02.api.Servlet;

import com.example.javaEE_02.api.service.CartService;
import com.example.javaEE_02.api.service.Impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加商品到购物车
 *
 * @Auther: hzy
 * @Date: 2021/12/5 15:45
 * @Description:
 */

@WebServlet("/addCartServlet")
public class addCartServlet extends HttpServlet {
    private final CartService cartService = new CartServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            cartService.addCommodity(req, resp);
        } catch (Exception e) {
            System.err.println("error:  " + e);
            resp.getWriter().println("请先登录！");
        }
    }
}
