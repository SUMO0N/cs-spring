package cn.cs.springframework.test.common;

import cn.cs.springframework.beans.BeansException;
import cn.cs.springframework.beans.factory.config.BeanPostProcessor;
import cn.cs.springframework.test.bean.UserService;

/**
 * @Author cs
 * @Date 2022-11-28 18:28
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：杭州");
        }
        System.out.println(beanName + " postProcessBeforeInitialization...");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " postProcessAfterInitialization...");
        return bean;
    }
}
