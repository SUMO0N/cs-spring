package cn.cs.springframework.test.bean;

/**
 * @Author cs
 * @Date 2022-11-25 11:20
 */
public class UserService {
    private String uid;
    private UserDao userDao;

    public UserService() {
    }

    public UserService(String uid, UserDao userDao) {
        this.uid = uid;
        this.userDao = userDao;
    }

    public void query() {
        System.out.println("查询用户信息:" + userDao.queryUserName(uid));
    }
}
