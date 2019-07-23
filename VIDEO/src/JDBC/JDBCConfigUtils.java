package JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: J2EE_STUDY
 * @description: 通过读取配置文件的jdbc工具类
 * @author: Rodger Luo
 * @create: 2019-07-22 20:36
 **/
public class JDBCConfigUtils {
    private static String className;
    private static String jdbcUrl;
    private static String userName;
    private static String password;
    private static Connection con;


    static {
        try {
            readProperties();
            Class.forName(className);
            con = DriverManager.getConnection(jdbcUrl, userName, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("连接数据库异常：" + e);
        } catch (SQLException e) {
            throw new RuntimeException("连接数据库异常：" + e);
        }
    }

    private static void readProperties() {
        try {
            // 使用类加载器读取配置文件
            InputStream in = JDBCConfigUtils.class.getClassLoader().getResourceAsStream("JDBC/database.properties");
            Properties pro = new Properties();
            pro.load(in);
            className = pro.getProperty("database.className");
            jdbcUrl = pro.getProperty("database.jdbcurl");
            userName = pro.getProperty("database.name");
            password = pro.getProperty("database.password");
        } catch (IOException e) {
            throw new RuntimeException("读取配置文件异常：" + e);
        }
    }

    public static Connection getConnection() {
        return con;
    }
}
