package cn.cs.springframework.beans.factory;

import cn.cs.springframework.beans.BeansException;
import cn.cs.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.cs.springframework.beans.factory.config.BeanDefinition;
import cn.cs.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @Author cs
 * @Date 2022-11-25 16:56
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, ConfigurableBeanFactory, AutowireCapableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
