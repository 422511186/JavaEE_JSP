package com.example.javaEE.Service.Impl;

import com.example.javaEE.Service.UserService;
import com.example.javaEE.Utils.Base64Utils;
import com.example.javaEE.Utils.VerifyCodeUtil;
import com.example.javaEE.pojo.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


public class UserServiceImpl implements UserService {

    private final List<User> userList;    //用户列表
    private final Integer OUT_TIME = 60 * 60 * 24;   //Cookie的过期时间


    //模拟存储用户信息数据库
    public UserServiceImpl() {
        userList = new ArrayList<User>(){{
//            add(new User("万杨洋", "201921098099"));
            add(new User("岳晓阳", "201921098131"));
            add(new User("邓建", "201921098133"));
            add(new User("王苏米娅", "201921098176"));
            add(new User("黄振宇", "201921098210"));
        }};
    }

    @Override
    public boolean doService(User user) {
        if (user == null)
            return false;
        return userList.contains(user);
    }

    //账号信息的校验
    @Override
    public void Login(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(username, password);
        boolean doService = doService(user);
        if (!doService) {
            request.getRequestDispatcher("Page/service/loginfail.jsp").forward(request, response);
            return;
        }
        //登录成功，将用户信息存入session域
        session.setAttribute("User", user);

        RmPassword(request, response);

        request.getRequestDispatcher("Page/service/loginSucceed.jsp").forward(request, response);
    }

    @Override
    public boolean register(User user) {
        System.out.println("user = " + user);
        int f = 0;
        for (User user1 : userList) {
            if (user1.getUsername().equals(user.getUsername())) {
                f = 1;
                return false;
            }
        }
        if (f == 0) {
            userList.add(user);
        }
        return true;
    }

    //记住密码
    @Override
    public void RmPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberPwd = request.getParameter("rememberPwd");

        Cookie[] cookies = request.getCookies();

        int usernameFlag = 0;//标记username的cookie是否找到
        int pwFlag = 0;//标记password的cookie是否找到

        if ("记住密码".equals(rememberPwd)) {
            for (Cookie c : cookies) {
                //找到了key为username的cookie
                if ("username".equals(c.getName())) {
                    //判断当前登录用户名是否和cookie中含有的用户名相同，不是的话更新该cookie的值
                    if (!URLEncoder.encode(username, "UTF-8").equals(c.getValue())) {
                        c.setMaxAge(OUT_TIME);//重置过期时间
                        c.setValue(URLEncoder.encode(username, "UTF-8"));
                    }
                    usernameFlag = 1;//标记username的cookie已找到
                }
                //找到了key为password的cookie
                if ("password".equals(c.getName())) {
                    //判断当前登录用户密码是否和cookie中含有的用户密码相同，不是的话更新该cookie的值
                    if (!password.equals(c.getValue())) {
                        c.setMaxAge(OUT_TIME);//重置过期时间
                        c.setValue(password);
                    }
                    pwFlag = 1;//标记password的cookie已找到
                }

            }
             if (usernameFlag==0){  //设置cookie的过期时间为24h
                Cookie userNameCookie = new Cookie("username", URLEncoder.encode(username, "UTF-8"));
                userNameCookie.setMaxAge(OUT_TIME);
                response.addCookie(userNameCookie);
            }
             if (pwFlag==0){    //设置cookie的过期时间为24h
                Cookie passwordCookie = new Cookie("password", password);
                passwordCookie.setMaxAge(OUT_TIME);
                response.addCookie(passwordCookie);
            }
        } else {
            //未勾选记住密码，且登录验证成功，则将删除cookie
            for (Cookie c : cookies) {  //遍历cookie，寻找username和password的key，删除
                if ("username".equals(c.getName())) {   //找到username的cookie
                    Cookie username1 = new Cookie("username", null);
                    username1.setMaxAge(0);
                    response.addCookie(username1);
                }
                if ("password".equals(c.getName())) {   //找到password的cookie
                    Cookie password1 = new Cookie("password", null);
                    password1.setMaxAge(0);
                    response.addCookie(password1);
                }
            }
        }
    }

    //获取验证码
    public static String getImageCode(HttpServletRequest request) {
        HttpSession session = request.getSession();
        try {
            String code = VerifyCodeUtil.generateVerifyCode(4);

            System.out.println(code);    //在控制台输出验证码

            session.setAttribute("code", code);

            ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();

            VerifyCodeUtil.outputImage(220, 60, byteArrayInputStream, code);

            return "data:image/png;base64," +
                    Base64Utils.encodeToString(byteArrayInputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }


}
