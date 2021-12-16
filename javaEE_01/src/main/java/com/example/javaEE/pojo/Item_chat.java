package com.example.javaEE.pojo;

/**
 * 单次聊天信息列表项的实体类
 *
 * @Auther: hzy
 * @Date: 2021/11/10 19:06
 * @Description:
 */
public class Item_chat {
    private String username;
    private String msg;

    public Item_chat() {
    }

    public Item_chat(String username, String msg) {
        this.username = username;
        this.msg = msg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Item_chat{" +
                "username='" + username + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
