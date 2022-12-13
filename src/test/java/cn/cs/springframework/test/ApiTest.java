package cn.cs.springframework.test;

import cn.cs.springframework.context.support.ClassPathXmlApplicationContext;
import cn.cs.springframework.test.bean.A;
import cn.cs.springframework.test.bean.B;
import cn.cs.springframework.test.bean.IUserService;

/**
 * @Author cs
 * @Date 2022-11-25 11:17
 */
public class ApiTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
//        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        A a = applicationContext.getBean("a", A.class);
        B b = applicationContext.getBean("b", B.class);
        System.out.println(a.getB());
        System.out.println(b);
        System.out.println(a.getB().query());
        System.out.println(b.getA().query());
    }
}
