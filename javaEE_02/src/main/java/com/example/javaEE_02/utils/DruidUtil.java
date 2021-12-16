package com.example.javaEE_02.utils;

import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Collections;
import java.util.Properties;

/**
 * 德鲁伊连接池工具类
 * 获取连接
 *
 * @Auther: hzy
 * @Date: 2021/11/27 18:40
 * @Description:
 */

public class DruidUtil {
    private static DruidDataSource dataSource = null;

    static {
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "DEBUG");
        Slf4jLogFilter slf4jLogFilter = new Slf4jLogFilter();
        // 是否 打印Connection 日志
        slf4jLogFilter.setConnectionLogEnabled(false); // 默认 true
        // Statement 日志
        slf4jLogFilter.setStatementLogEnabled(true);  // 默认 true
        // 是否 打印PreparedStatement语句
        slf4jLogFilter.setStatementPrepareAfterLogEnabled(false);  // 默认 true
        // 是否 打印PreparedStatement语句参数和参数类型
        slf4jLogFilter.setStatementParameterSetLogEnabled(false);  // 默认 true
        // ❤❤❤ 是否 打印Statement可执行语句
        slf4jLogFilter.setStatementExecutableSqlLogEnable(true);  // ❤ 默认 false
        // ❤❤❤ 是否 打印执行耗时
        slf4jLogFilter.setStatementExecuteQueryAfterLogEnabled(false); // 默认 true
        // 是否 打印 Statement close 日志
        slf4jLogFilter.setStatementCloseAfterLogEnabled(false); // 默认 true
        // 是否 打印 执行结果
        slf4jLogFilter.setResultSetLogEnabled(false);  // 默认 true

        try {
            Properties pros = new Properties();
            InputStream is = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pros.load(is);
            //根据提供的BasicDataSourceFactory创建对应的DataSource对象
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pros);

            // 设置过滤器
            dataSource.setProxyFilters(Collections.singletonList(slf4jLogFilter));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //从数据库连接池获取数据库连接
    public static Connection getConnection() throws Exception {
        Connection conn = dataSource.getConnection();
        return conn;
    }

}
