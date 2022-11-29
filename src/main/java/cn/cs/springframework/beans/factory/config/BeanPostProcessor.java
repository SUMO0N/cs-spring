package cn.cs.springframework.beans.factory.config;

import cn.cs.springframework.beans.BeansException;

/**
 * @Author cs
 * @Date 2022-11-28 17:24
 */
public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
