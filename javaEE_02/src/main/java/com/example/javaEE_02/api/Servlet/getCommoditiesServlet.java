package com.example.javaEE_02.api.Servlet;

import com.example.javaEE_02.api.service.CommodityService;
import com.example.javaEE_02.api.service.Impl.CommodityServiceImpl;
import com.example.javaEE_02.pojo.Commodity;
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
 * @Auther: hzy
 * @Date: 2021/12/5 15:06
 * @Description:
 */
@WebServlet("/getCommodities")
public class getCommoditiesServlet extends HttpServlet {
    private CommodityService commodityService = new CommodityServiceImpl();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");//设置返回json格式

        List<Commodity> list = commodityService.getCommodities();
        PrintWriter writer = resp.getWriter();
        writer.println(gson.toJson(list));

    }
}
