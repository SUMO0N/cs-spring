package cn.cs.springframework.beans.factory.support;

import cn.cs.springframework.beans.BeansException;
import cn.cs.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author cs
 * @Date 2022-11-25 14:14
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiation(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            if (ctor == null) {
                return beanClass.getDeclaredConstructor().newInstance();
            } else {
                return beanClass.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
