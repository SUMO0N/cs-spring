package cn.cs.springframework.beans.factory.config;

import cn.cs.springframework.beans.BeansException;
import cn.cs.springframework.beans.PropertyValues;

/**
 * @Author cs
 * @Date 2022-12-08 10:47
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{
    Object postProcessBeforeInitialization(Class<?> beanClass, String beanName) throws BeansException;
    boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;
    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException;
}
