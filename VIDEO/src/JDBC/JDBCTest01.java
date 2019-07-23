package JDBC;

import java.sql.Connection;

/**
 * @program: J2EE_STUDY
 * @description:
 * @author: Rodger Luo
 * @create: 2019-07-22 21:42
 **/
public class JDBCTest01 {
    public static void main(String[] args) {
        Connection con = JDBCConfigUtils.getConnection();
        System.out.println(con);
    }
}
