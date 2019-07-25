package JDBC.DBCP;

/**
 * @program: J2EE_STUDY
 * @description:
 * @author: Rodger Luo
 * @create: 2019-07-24 17:31
 **/
public class UserInfoTest {

    private static UserBehaviorService service = new UserBehaviorService();

    public static void main(String[] args) {
        System.out.println(service.login("lz","123456"));
        System.out.println(service.login("lz","12345"));
    }
}
