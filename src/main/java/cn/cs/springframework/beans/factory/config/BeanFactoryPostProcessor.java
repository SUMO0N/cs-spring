package cn.cs.springframework.beans.factory.config;

import cn.cs.springframework.beans.BeansException;
import cn.cs.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @Author cs
 * @Date 2022-11-28 17:24
 */
public interface BeanFactoryPostProcessor {
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
