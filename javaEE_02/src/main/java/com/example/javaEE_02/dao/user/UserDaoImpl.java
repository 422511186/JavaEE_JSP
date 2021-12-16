package com.example.javaEE_02.dao.user;

import com.example.javaEE_02.dao.basedao;
import com.example.javaEE_02.pojo.User;
import org.testng.annotations.Test;

public class UserDaoImpl extends basedao implements UserDao {

    @Override
    public User queryUserByAccount(String user_account) throws Exception {
        String sql = "select id, user_account, password from user where user_account=?";
        User user = queryForOne(User.class, sql, user_account);
        return user;
    }

    @Override
    public User queryUserById(Integer id) throws Exception {
        String sql = "select id,user_account,password from user where id=?";
        User user = queryForOne(User.class, sql, id);
        return user;
    }

    @Override
    public int saveUser(User user) throws Exception {
        String sql = "INSERT INTO user (user_account, password) VALUES (?,?)";
        int update = update(sql, user.getUser_account(), user.getPassword());
        return update;
    }

    @Override
    public int updataPassword(Integer id, String password) throws Exception {
        String sql = "update user set password=? where id=?";
        int update = update(sql, password, id);
        return update;
    }

    @Override
    public int deleteUserById(Integer id) throws Exception {
        String sql = "delete from user where id=?";
        int update = update(sql, id);
        return update;
    }

    @Test
    void p() throws Exception {

        // 通过用户id删除某个用户
//        deleteUserById(2);

        // 通过用户的id修改用户密码
        //updataPassword(2, "987456321");

        // 通过用户的id查找用户
        //User user = queryUserById(1);
        //System.out.println(user.getUser_account() + user.getPassword());

        // 通过用户账号查找用户
        //User user = queryUserByAccount("test");
        //System.out.println(user.getUser_account() + user.getPassword());

        User user = new User(1, "nn", "123456");
//         参数为一个用户对象
        saveUser(user);
        //System.out.println(user.getUser_account());
    }
}
