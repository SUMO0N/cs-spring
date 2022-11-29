package cn.cs.springframework.test.bean;

import cn.cs.springframework.beans.factory.DisposableBean;
import cn.cs.springframework.beans.factory.InitializingBean;

/**
 * @Author cs
 * @Date 2022-11-25 11:20
 */
public class UserService implements InitializingBean, DisposableBean {
    private String uid;
    private String company;
    private String location;
    private UserDao userDao;

    public String query() {
        return userDao.queryUserName(uid)+", 公司："+company+", 地点"+location;
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

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("执行：UserService.afterPropertiesSet");
    }
}
