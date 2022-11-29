package cn.cs.springframework.test.bean;

import cn.cs.springframework.beans.BeansException;
import cn.cs.springframework.beans.factory.*;
import cn.cs.springframework.context.ApplicationContext;
import cn.cs.springframework.context.ApplicationContextAware;

/**
 * @Author cs
 * @Date 2022-11-25 11:20
 */
public class UserService implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {
    private String uid;
    private String company;
    private String location;
    private UserDao userDao;

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public String query() {
        return userDao.queryUserName(uid)+", 公司："+company+", 地点:"+location;
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
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is：" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
