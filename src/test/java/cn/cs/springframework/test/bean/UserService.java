package cn.cs.springframework.test.bean;

import cn.cs.springframework.beans.factory.annotation.Autowired;
import cn.cs.springframework.beans.factory.annotation.Value;
import cn.cs.springframework.stereotype.Component;

/**
 * @Author cs
 * @Date 2022-11-25 11:20
 */
@Component("userService")
public class UserService implements IUserService{
    @Value("${token}")
    private String token;
    @Autowired
    private UserDao userDao;

    public String query() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return userDao.queryUserName("10001");
    }

    public String register(String name) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return name + ", register!";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "token='" + token + '\'' +
                '}';
    }
}
