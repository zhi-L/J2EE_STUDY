package JDBC.DBCP;

import JDBC.JDBCConfigUtils;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @program: J2EE_STUDY
 * @description:
 * @author: Rodger Luo
 * @create: 2019-07-24 14:28
 **/
public class JDBCUtils {

    private static BasicDataSource dataSource = new BasicDataSource();
    private static String className;
    private static String jdbcUrl;
    private static String userName;
    private static String password;
    private static Integer initialSize;
    private static Integer maxTotal;
    private static Integer maxIdle;
    private static Integer minIdle;

    static {
        readProperties();
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setUrl(jdbcUrl);
        dataSource.setDriverClassName(className);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxTotal(maxTotal);
        dataSource.setMaxIdle(maxIdle);
        dataSource.setMinIdle(minIdle);
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
            initialSize = Integer.valueOf(pro.getProperty("dbcp.initialSize"));
            maxTotal = Integer.valueOf(pro.getProperty("dbcp.maxTotal"));
            maxIdle = Integer.valueOf(pro.getProperty("dbcp.maxIdle"));
            minIdle = Integer.valueOf(pro.getProperty("dbcp.minIdle"));
        } catch (IOException e) {
            throw new RuntimeException("读取配置文件异常：" + e);
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
