package JDBC;


import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * @program: J2EE_STUDY
 * @description:
 * @author: Rodger Luo
 * @create: 2019-07-18 21:53
 **/

/*
    JDBC 操作数据库的步骤
    1、注册驱动
        告知JVM使用的是哪一个数据库的驱动
    2、获得链接
        使用JDBC中的类完成对MySQL数据库的链接
    3、获得语句执行平台
        通过链接对象，获取对sql语句的执行者对象
    4、执行sql语句
        使用执行者对象，向数据库执行sql语句
        获取到数据库的执行后的结果
    5、处理结果
    6、释放资源
        close()
 */
public class JDBCDemo01 {

    private static void updataDemo() throws Exception{
        //  1、注册驱动 通过反射技术，将驱动类加入到内容
        // 使用java.sql.DriverManager类静态方法registerDriver(Driver driver)
        // Driver是一个接口，参数传递，MySQL驱动程序中的实现类
//        DriverManager.registerDriver(new Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2、获取数据库的连接 DriverManager类中静态方法
        // static Connection	getConnection(String url, String user, String password)
        // 返回值Connection接口的实现类，在MySQL驱动程序
        String jdbcUrl = "jdbc:mysql://192.168.100.5:3306/learn_spring?characterEncoding=utf8";
        String name = "lz";
        String password = "luozhi0430";
        Connection con = DriverManager.getConnection(jdbcUrl, name, password);

        // 3、获得语句执行平台，通过数据库，获取到SQL语句的执行者对象。
        // TODO,这里使用建议使用preparedStatement()来防止注入攻击，见JDBCDemo2
        Statement stat = con.createStatement();

        // 4、执行sql语句
        int row = stat.executeUpdate("insert into Shohin (shohin_id,shohin_mei,shohin_bunrui,hanbai_tanka,shiire_tanka,torokubi) values ('0009','钢笔','办公用品',300,500,'2019-07-20'); ");
        System.out.println(row);

        stat.close();
        con.close();
    }

    private static void selectDemo() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String jdbcUrl = "jdbc:mysql://192.168.100.5:3306/learn_spring?characterEncoding=utf8";
        String name = "lz";
        String password = "luozhi0430";
        Connection con = DriverManager.getConnection(jdbcUrl, name, password);

        Statement stat = con.createStatement();

        ResultSet rs = stat.executeQuery("select * from Shohin;");
        // 处理结果集
        while(rs.next()) {
            System.out.println(rs.getString("shohin_id"));
        }

        rs.close();
        stat.close();
        con.close();

    }


    public static void main(String[] args) throws Exception{
        selectDemo();
    }
}
