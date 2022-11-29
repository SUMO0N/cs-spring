package cn.cs.springframework.test;

import cn.cs.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.cs.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.cs.springframework.context.support.ClassPathXmlApplicationContext;
import cn.cs.springframework.test.bean.UserService;
import cn.cs.springframework.test.common.MyBeanFactoryPostProcessor;
import cn.cs.springframework.test.common.MyBeanPostProcessor;

/**
 * @Author cs
 * @Date 2022-11-25 11:17
 */
public class ApiTest {
    public static void main(String[] args) {
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
//        reader.loadBeanDefinitions("classpath:spring.xml");
//
//        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
//        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
//
//        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
//        beanFactory.addBeanPostProcessor(beanPostProcessor);
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registryShutdownHook();
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService.query());
    }
}
