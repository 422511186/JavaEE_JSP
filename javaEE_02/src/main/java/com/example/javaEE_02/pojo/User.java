package com.example.javaEE_02.pojo;

/**
 * 用户账户实体类
 *
 * @Auther: hzy
 * @Date: 2021/11/27 18:44
 * @Description:
 */

public class User {

    private Integer id;//用户id
    private String user_account;//用户账号
    private String password;//用户密码

    public User(Integer id, String user_account, String password) {
        this.id = id;
        this.user_account = user_account;
        this.password = password;
    }

    public User() {

    }

    ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_account='" + user_account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
