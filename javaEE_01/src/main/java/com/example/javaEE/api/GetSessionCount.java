package com.example.javaEE.api;

import com.example.javaEE.FactoryBean;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;

/**
 * 获取在线用户和人数
 *
 * @Auther: hzy
 * @Date: 2021/11/11 16:15
 * @Description:
 */
@WebServlet("/GetCount")
public class GetSessionCount extends HttpServlet {
    private Gson gson = FactoryBean.getGson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");//设置返回json格式
        Set set = (Set) getServletContext().getAttribute("set");

        HashMap<String, Object> map = new HashMap<>();

        map.put("size", set.size());
        map.put("set", set);

        //将Map序列化成json返回
        String mapJson = gson.toJson(map);
        PrintWriter writer = resp.getWriter();
        writer.println(mapJson);
        writer.close();
    }

}
