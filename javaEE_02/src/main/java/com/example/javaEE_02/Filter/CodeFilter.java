package com.example.javaEE_02.Filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 字符集统一过滤器
 *
 * @Auther: hzy
 * @Date: 2021/11/10 21:53
 * @Description:
 */

//@WebFilter(filterName = "codeFilter", urlPatterns = "/*")
public class CodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
