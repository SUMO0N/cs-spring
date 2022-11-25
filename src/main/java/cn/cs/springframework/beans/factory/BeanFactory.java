package cn.cs.springframework.beans.factory;

import cn.cs.springframework.beans.BeansException;

/**
 * @Author cs
 * @Date 2022-11-25 11:13
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
