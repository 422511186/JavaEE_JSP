package com.example.javaEE_02.api.Servlet;

import com.example.javaEE_02.api.service.CartService;
import com.example.javaEE_02.api.service.Impl.CartServiceImpl;
import com.example.javaEE_02.pojo.Carts;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 获取购物车列表
 *
 * @Auther: hzy
 * @Date: 2021/12/5 22:22
 * @Description:
 */
@WebServlet("/getCartListServlet")
public class getCartListServlet extends HttpServlet {
    private final CartService service = new CartServiceImpl();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");//设置返回json格式

        List<Carts> cartList = service.getCartList(req, resp);
        PrintWriter writer = resp.getWriter();
        writer.println(gson.toJson(cartList));

    }
}
