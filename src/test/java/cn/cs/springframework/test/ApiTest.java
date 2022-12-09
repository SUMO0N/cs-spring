package cn.cs.springframework.test;

import cn.cs.springframework.context.support.ClassPathXmlApplicationContext;
import cn.cs.springframework.test.bean.IUserService;

/**
 * @Author cs
 * @Date 2022-11-25 11:17
 */
public class ApiTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println(userService.query());
    }
}
