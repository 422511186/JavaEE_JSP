import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.example.javaEE_02.utils.DruidUtil;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @Auther: hzy
 * @Date: 2021/11/27 18:29
 * @Description:
 */
public class sqliteTest {
    @Test
    public void test1() throws Exception {
        //1.加载配置文件
        InputStream is = sqliteTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);
        //2.读取配置信息

        String url = pros.getProperty("jdbc.url");
        String driverClass = pros.getProperty("jdbc.driver");
        //3.加载驱动
        Class.forName(driverClass);
        //4.获取连接
        Connection conn = DriverManager.getConnection(url);
        System.out.println(conn);
    }

    @Test
    public void test2() throws Exception {
        Properties pro = new Properties();
        pro.load(sqliteTest.class.getClassLoader().getResourceAsStream("druid.properties"));
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }

    @Test
    public void test3() throws Exception {
        Connection conn = DruidUtil.getConnection();
        System.out.println("conn = " + conn);
    }

}
