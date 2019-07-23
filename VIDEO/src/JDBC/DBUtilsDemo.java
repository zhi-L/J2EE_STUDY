package JDBC;

import JDBC.domain.Shohin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @program: J2EE_STUDY
 * @description:
 * @author: Rodger Luo
 * @create: 2019-07-23 16:23
 **/
public class DBUtilsDemo {

    private static Connection con = JDBCConfigUtils.getConnection();

    private static void insertTest() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "INSERT INTO Shohin (`shohin_id`,`shohin_mei`,`shohin_bunrui`,`hanbai_tanka`,`shiire_tanka`,`torokubi`) VALUES (?, ?,?,?,?,?);";
        Object[] params = {"0010", "笔记本", "办公用品", 200, 200, "2019-07-23"};
        int result = qr.execute(con, sql, params);
        System.out.println(result);
    }

    private static void deleteTest() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "DELETE FROM Shohin WHERE `shohin_id` = ?;";
        int result = qr.execute(con, sql, "0010");
        System.out.println(result);
    }

    private static void arrayHandlerTest() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM Shohin";
        Object[] result = qr.query(con, sql, new ArrayHandler());
        for (Object object:result) {
            System.out.println(object);
        }
    }

    private static void qrrayListHandlerTest() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM Shohin";
        List<Object[]> list = qr.query(con, sql, new ArrayListHandler());
        for (Object[] item:list) {
            for (Object ob : item) {
                System.out.print(ob + "  ");
            }
            System.out.println();
        }
    }

    private static void beanHandlerTest() throws SQLException {
        QueryRunner qr = new QueryRunner();
        // 因为bean的属性与数据库中的字段名称不一致
        // 因为字段名是通过方法rsmd.getColumnLabel(col)来取得的,所以可以把字段名与属性名的映射关系写在SQL语句里面
        String sql = "SELECT `shohin_id` AS shohinId, `shohin_mei` AS shohinMei, `shohin_bunrui` AS shohinBunrui, `hanbai_tanka` AS hanbaiTanka, `shiire_tanka` AS shiireTanka, `torokubi` FROM Shohin;";
        Shohin shohin = qr.query(con, sql, new BeanHandler<Shohin>(Shohin.class));
        System.out.println(shohin);
    }

    private static void beanListHandlerTest() throws SQLException {
        QueryRunner qr = new QueryRunner();
        // 因为bean的属性与数据库中的字段名称不一致
        // 因为字段名是通过方法rsmd.getColumnLabel(col)来取得的,所以可以把字段名与属性名的映射关系写在SQL语句里面
        String sql = "SELECT `shohin_id` AS shohinId, `shohin_mei` AS shohinMei, `shohin_bunrui` AS shohinBunrui, `hanbai_tanka` AS hanbaiTanka, `shiire_tanka` AS shiireTanka, `torokubi` FROM Shohin;";
        List<Shohin> shohinList = qr.query(con, sql, new BeanListHandler<Shohin>(Shohin.class));
        for (Shohin shohin: shohinList) {
            System.out.println(shohin);
        }
    }

    private static void mapHandlerTest() throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM Shohin";
        Map resultMap = qr.query(con, sql, new MapHandler());
        resultMap.forEach((k,v) -> {
            System.out.println(k + ": " + v);
        });
    }

    private static void mapListHandlerTest() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM Shohin";
        List<Map<String, Object>> resultMapList = qr.query(con, sql, new MapListHandler());
        for (Map resultMap: resultMapList) {
            Iterator<Map.Entry<String, Object>> entryIterator = resultMap.entrySet().iterator();
            while (entryIterator.hasNext()) {
                Map.Entry<String, Object> entry = entryIterator.next();
                System.out.println(entry.getKey() + ": " + entry.getValue() + "  ");
            }
            System.out.println();
        }
    }

    private static void scalarHandlerTest() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT COUNT(1) FROM Shohin";
        Long count = qr.query(con, sql, new ScalarHandler<Long>());
        System.out.println(count);
    }

    public static void main(String[] args) {
        try {
//            insertTest();
//            deleteTest();
//            arrayHandlerTest();
//            qrrayListHandlerTest();
//            beanHandlerTest();
//            beanListHandlerTest();
//            mapHandlerTest();
//            mapListHandlerTest();
            scalarHandlerTest();
        } catch (SQLException e) {
            throw new RuntimeException("错误：" + e);
        }
    }

}
