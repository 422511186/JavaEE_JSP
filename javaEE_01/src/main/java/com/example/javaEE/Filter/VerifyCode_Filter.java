package com.example.javaEE.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 拦截登录请求，并校验验证码是否正确
 *
 * @Auther: hzy
 * @Date: 2021/10/7 17:55
 * @Description:
 */
//@WebFilter(filterName = "verifyCode_Filter", urlPatterns = {"/Register", "/Login"})
public class VerifyCode_Filter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        response.setContentType("text/html;charset=utf-8");
//        request.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();

        String yzm = request.getParameter("yzm");

        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpSession session = request1.getSession();
        String code = (String) session.getAttribute("code");

        System.out.println("code = " + code);
        if (!code.equals(yzm)) {
            writer.print("<h1>验证码错误！</h1>");
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
