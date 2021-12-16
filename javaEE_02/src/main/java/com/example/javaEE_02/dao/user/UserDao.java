package com.example.javaEE_02.dao.user;

import com.example.javaEE_02.pojo.User;

public interface UserDao {
    /**
     * 通过用户账号查询用户
     *
     * @param user_account
     * @return
     */
    public User queryUserByAccount(String user_account) throws Exception;

    /**
     * 根据用户名查询用户信息
     *
     * @param id 用户名
     * @return 如果返回null, 说明没有这个用户。反之亦然
     */
    public User queryUserById(Integer id) throws Exception;

    /**
     * 保存用户信息
     *
     * @param user
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int saveUser(User user) throws Exception;

    /**
     * 修改用户的密码
     *
     * @param id 用户的id
     * @return
     */
    public int updataPassword(Integer id, String password) throws Exception;

    /**
     * 通过用户id删除某用户
     *
     * @param id
     * @return
     */
    public int deleteUserById(Integer id) throws Exception;

}
