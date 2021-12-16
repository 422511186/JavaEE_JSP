package com.example.javaEE.api;

import com.example.javaEE.pojo.Item_chat;
import com.example.javaEE.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 发送信息
 *
 * @Auther: hzy
 * @Date: 2021/11/9 11:43
 * @Description:
 */


@WebServlet("/ChatRoom")
public class ChatRoomServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("User");
        String msg = req.getParameter("msg");
        Item_chat item_chat = new Item_chat(user.getUsername(), msg);
        List<Item_chat> list = (List<Item_chat>) getServletContext().getAttribute("list");
        if (list == null)
            list = new ArrayList<>();
        list.add(item_chat);
        getServletContext().setAttribute("list", list);

        PrintWriter writer = resp.getWriter();
        writer.print(user.getUsername());
    }

}
