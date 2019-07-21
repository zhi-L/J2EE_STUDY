package JDBC;

import java.sql.*;

/**
 * @program: J2EE_STUDY
 * @description: 实现JDBC的工具类
 *                 定义方法，直接返回数据库的连接对象
 * @author: Rodger Luo
 * @create: 2019-07-21 23:57
 **/
public class JDBCUtils {
    private JDBCUtils(){}
    public static Connection con;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcUrl = "jdbc:mysql://192.168.100.5:3306/learn_spring?characterEncoding=utf8";
            String name = "lz";
            String password = "luozhi0430";
            con = DriverManager.getConnection(jdbcUrl, name, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e + "数据库连接异常");
        } catch (SQLException e) {
            throw new RuntimeException(e + "数据库连接异常");
        }
    }

    /*
    定义静态方法，返回数据库的连接对象
     */
    public static Connection getConnection() {
        return con;
    }

    public static void close(Connection con, Statement stat) {

        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection con, Statement stat, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
