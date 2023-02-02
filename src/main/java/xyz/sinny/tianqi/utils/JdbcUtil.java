package xyz.sinny.tianqi.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    static DruidDataSource dataSource;

    static {
        Properties properties = new Properties();
        InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("DB_conf\\jdbc.properties");
        try {
            properties.load(in);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection conn){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
