package cn.cs.springframework.test.bean;

import cn.cs.springframework.beans.BeansException;
import cn.cs.springframework.beans.factory.*;
import cn.cs.springframework.context.ApplicationContext;
import cn.cs.springframework.context.ApplicationContextAware;

/**
 * @Author cs
 * @Date 2022-11-25 11:20
 */
public class UserService implements IUserService{
    private String uid;
    private String company;
    private String location;
    private IUserDao userDao;

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

}
