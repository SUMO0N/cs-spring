package cn.cs.springframework.test.bean;

import cn.cs.springframework.stereotype.Component;

/**
 * @Author cs
 * @Date 2022-11-25 11:20
 */
@Component("userService")
public class UserService implements IUserService{
    private String token;

    public String query() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return "cool";
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
