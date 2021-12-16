package com.example.javaEE;

import com.example.javaEE.Service.Impl.UserServiceImpl;
import com.example.javaEE.Service.UserService;
import com.google.gson.Gson;

/**
 * 自定义JavaBean工厂
 *
 * @Auther: hzy
 * @Date: 2021/11/7 20:44
 * @Description:
 */

public class FactoryBean {

    private static UserService userService;
    private static Gson gson;

    public static UserService getUserService() {

        if (userService == null) {
            synchronized (FactoryBean.class) {
                if (userService == null) {
                    userService = new UserServiceImpl();
                }
            }
        }
        return userService;
    }

    public static Gson getGson() {
        if (gson == null) {
            synchronized (FactoryBean.class) {
                if (gson == null) {
                    gson = new Gson();
                }
            }
        }
        return gson;
    }

}
