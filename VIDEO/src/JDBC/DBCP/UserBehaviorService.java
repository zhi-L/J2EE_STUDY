package JDBC.DBCP;

import com.mysql.cj.util.StringUtils;
import org.junit.Test;

/**
 * @program: J2EE_STUDY
 * @description:
 * @author: Rodger Luo
 * @create: 2019-07-24 17:19
 **/
public class UserBehaviorService {

    private static UserInfoDao userInfoDao = new UserInfoDao();

    public Boolean login(String userName, String password) {
        boolean flag = false;
        String queryUserNameResult = userInfoDao.queryUserName(userName);
        if (StringUtils.isEmptyOrWhitespaceOnly(queryUserNameResult)) {
            int insertResult = userInfoDao.insert(userName, password);
            if (insertResult == 1)
                flag = true;
        } else {
            Object[] result = userInfoDao.queryUserNamePassword(userName, password);
            if (result.length > 0) {
                flag = true;
            }
        }
        return flag;
    }
}
