package cn.cs.springframework.test.bean;

import cn.cs.springframework.beans.factory.annotation.Autowired;
import cn.cs.springframework.beans.factory.annotation.Value;
import cn.cs.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @Author cs
 * @Date 2022-11-25 11:20
 */
//@Component("userService")
public class UserService implements IUserService{
//    @Value("${token}")
    private String token;
//    @Autowired
    private LocalDate createDate;

    public String query() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return token;
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

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "token='" + token + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
