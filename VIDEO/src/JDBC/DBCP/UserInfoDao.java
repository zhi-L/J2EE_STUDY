package JDBC.DBCP;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.SQLException;

/**
 * @program: J2EE_STUDY
 * @description:
 * @author: Rodger Luo
 * @create: 2019-07-24 16:41
 **/
public class UserInfoDao {

    private static QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    private static final Log log = LogFactory.getLog(UserInfoDao.class);

    public int insert(String userName, String password) {
        try {
            String sql = "INSERT INTO user_info (`user_name`,`password`) VALUES (?,?);";
            Object[] params = {userName, password};
            return qr.execute(sql, params);
        } catch (SQLException e) {
            log.error("插入数据库失败，error:{}", e);
            return 0;
        }
    }

    public String queryUserName(String userName) {
        try {
            String sql = "SELECT `user_name` AS userName FROM user_info WHERE user_name = ?;";
            Object[] params = {userName};
            Object[] result = qr.query(sql, new ArrayHandler(), params);
            if (result.length > 0) {
                return String.valueOf(result[0]);
            }
            return null;
        } catch (SQLException e) {
            log.error("查询用户名失败，error:{}", e);
            return null;
        }
    }

    public Object[] queryUserNamePassword(String userName, String password) {
        try {
            String sql = "SELECT `user_name` AS userName FROM user_info WHERE user_name = ? AND password = ?;";
            Object[] params = {userName, password};
            return qr.query(sql, new ArrayHandler(), params);
        } catch (SQLException e) {
            log.error("查询用户失败，error:{}", e);
            return null;
        }
    }
}
