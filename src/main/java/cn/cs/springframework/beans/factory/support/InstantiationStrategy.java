package cn.cs.springframework.beans.factory.support;

import cn.cs.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Author cs
 * @Date 2022-11-25 14:02
 */
public interface InstantiationStrategy {
    Object instantiation(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args);
}
