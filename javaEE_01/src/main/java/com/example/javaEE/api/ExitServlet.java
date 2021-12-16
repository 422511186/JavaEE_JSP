package com.example.javaEE.api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/exit")
public class ExitServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String button = req.getParameter("exit");
        if(button.equals("on")){
            HttpSession session = req.getSession();
            session.invalidate();
        }
        resp.sendRedirect("index.jsp");
    }

}
