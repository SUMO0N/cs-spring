package cn.cs.springframework.test;

import cn.cs.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.cs.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.cs.springframework.test.bean.UserService;

/**
 * @Author cs
 * @Date 2022-11-25 11:17
 */
public class ApiTest {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.query();
    }
}
