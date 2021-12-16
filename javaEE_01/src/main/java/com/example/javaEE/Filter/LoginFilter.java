package com.example.javaEE.Filter;

import com.example.javaEE.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录过滤器，避免未登陆账户直接进入聊天室
 *
 * @Auther: hzy
 * @Date: 2021/11/9 13:41
 * @Description:
 */

//@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
//        response.setContentType("text/html;charset=utf-8");
//        request.setCharacterEncoding("utf-8");

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String Url = httpServletRequest.getRequestURI();
        if (!Url.endsWith("chatRoom.jsp")) { //判断URL以jsp结尾
            chain.doFilter(request, response);
        } else {

            HttpSession session = httpServletRequest.getSession();

            User user = (User) session.getAttribute("User");

            if (user == null) {
                httpServletResponse.sendRedirect("/javaEE_01/Page/login.jsp");
            } else
                chain.doFilter(httpServletRequest, httpServletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}

