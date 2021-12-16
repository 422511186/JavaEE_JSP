package com.example.javaEE.api;

import com.example.javaEE.FactoryBean;
import com.example.javaEE.pojo.Item_chat;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

/**
 * 获取消息列表
 *
 * @Auther: hzy
 * @Date: 2021/11/11 17:26
 * @Description:
 */

@WebServlet("/getChatList")
public class getChatList extends HttpServlet {

    private Gson gson = FactoryBean.getGson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");//设置返回json格式

        List<Item_chat> list = (List<Item_chat>) getServletContext().getAttribute("list");
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);
        String mapJson = gson.toJson(map);
        PrintWriter writer = resp.getWriter();
        writer.println(mapJson);
        writer.close();

    }

}
