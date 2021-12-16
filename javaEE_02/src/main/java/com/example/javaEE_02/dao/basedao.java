package com.example.javaEE_02.dao;

import com.alibaba.druid.util.JdbcUtils;
import com.example.javaEE_02.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class basedao {
    private final QueryRunner queryRunner = new QueryRunner();

    /**
     * 增删改操作
     *
     * @param sql
     * @param args
     * @return 影响的行数，-1代表操作失败
     */
    public int update(String sql, Object... args) throws Exception {
        Connection connection = DruidUtil.getConnection();
        int update = 0;
        try {
            update = queryRunner.update(connection, sql, args);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connection.close();
        }
        return -1;
    }

    /**
     * 查询返回一个javaBean的sql语句
     *
     * @param tClass 类加载器
     * @param sql    sql语句
     * @param args   sql对应的参数值
     * @param <T>    返回类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> tClass, String sql, Object... args) throws Exception {
        Connection connection = DruidUtil.getConnection();
        try {
            T query = queryRunner.query(connection, sql, new BeanHandler<T>(tClass), args);
            return query;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            connection.close();
        }
        return null;
    }

    /**
     * 查询返回多个javaBean的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @param <T>  返回的类型的泛型
     * @return 返回的多个bean对象列表
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) throws Exception {
        Connection connection = DruidUtil.getConnection();
        try {
            List<T> list = queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
            return list;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            connection.close();
        }
        return null;
    }

    /**
     * 执行返回一行一列的sql语句
     *
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @return
     */
    public Object queryForSingleValue(String sql, Object... args) throws Exception {
        Connection connection = DruidUtil.getConnection();
        try {
            Object query = queryRunner.query(connection, sql, new ScalarHandler(), args);
            return query;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }
}
