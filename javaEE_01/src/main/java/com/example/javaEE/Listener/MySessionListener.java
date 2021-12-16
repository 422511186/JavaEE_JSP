package com.example.javaEE.Listener;

import com.example.javaEE.pojo.User;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Session监听器
 *
 * @Auther: hzy
 * @Date: 2021/11/10 10:30
 * @Description:
 */
@WebListener
public class MySessionListener implements HttpSessionAttributeListener, HttpSessionListener {
    private static Set<String> set;
    @Override
    public void sessionDestroyed(HttpSessionEvent e) {
        HttpSession session = e.getSession();
        ServletContext context = session.getServletContext();
        User user = (User) session.getAttribute("User");

        if (user != null) {
            Set<String> strings = (Set<String>) context.getAttribute("set");
            strings.remove(user.getUsername());
            System.out.println(user.getUsername() + "已退出");
            context.setAttribute("set", strings);
        }
    }
    @Override
    public void attributeAdded(HttpSessionBindingEvent e) {
        HttpSession session = e.getSession();
        ServletContext context = session.getServletContext();
        User user = (User) session.getAttribute("User");
        if (user != null) {
            set = (Set<String>) context.getAttribute("set");
            if (set != null) {
                set.add(user.getUsername());
                context.setAttribute("set", set);
                System.out.println("attributeAdded set = " + set);
            } else {
                set = new HashSet<>();
                set.add(user.getUsername());
                context.setAttribute("set", set);
                System.out.println("attributeAdded set = " + set);
            }
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent e) {
        HttpSession session = e.getSession();
        ServletContext context = session.getServletContext();
        User user = (User) session.getAttribute("User");
        if (user != null) {
            set = (Set<String>) context.getAttribute("set");
            if (set != null) {
                set.add(user.getUsername());
                context.setAttribute("set", set);
                System.out.println("attributeAdded set = " + set);
            } else {
                set = new HashSet<>();
                set.add(user.getUsername());
                context.setAttribute("set", set);
                System.out.println("attributeAdded set = " + set);
            }
        }
    }
}
