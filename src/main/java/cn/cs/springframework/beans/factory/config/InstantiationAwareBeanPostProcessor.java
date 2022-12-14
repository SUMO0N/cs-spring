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

    /**
     * 在 Spring 中由 SmartInstantiationAwareBeanPostProcessor#getEarlyBeanReference 提供
     * @param bean
     * @param beanName
     * @return
     */
    default Object getEarlyBeanReference(Object bean, String beanName) {
        return bean;
    }
}
