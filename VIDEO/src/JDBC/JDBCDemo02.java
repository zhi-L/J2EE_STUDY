package JDBC;

import JDBC.domain.Shohin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: J2EE_STUDY
 * @description:
 * @author: Rodger Luo
 * @create: 2019-07-22 00:25
 **/
public class JDBCDemo02 {

    /*
    JDBC读取数据库，并将读取到的数据封装到类对象中
     */
    private static void JDBCSelectDemo() throws Exception {
        Connection con = JDBCUtils.getConnection();
        PreparedStatement pst = con.prepareStatement("select * from Shohin;");
        ResultSet rs = pst.executeQuery();

        List<Shohin> shohinList = new ArrayList<>();
        while (rs.next()) {
            shohinList.add(
                    new Shohin(
                            rs.getString("shohin_id"),
                            rs.getString("shohin_mei"),
                            rs.getString("shohin_bunrui"),
                            rs.getInt("hanbai_tanka"),
                            rs.getInt("shiire_tanka"),
                            rs.getDate("torokubi")
                            )
            );
        }

        for (Shohin shohin:shohinList) {
            System.out.println(shohin.getShohinMei());
        }

        JDBCUtils.close(con, pst, rs);
    }

    public static void main(String[] args) throws Exception{
        JDBCSelectDemo();
    }
}
