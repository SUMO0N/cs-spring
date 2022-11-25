package cn.cs.springframework.beans.factory;

import cn.cs.springframework.beans.BeansException;

import java.util.Map;

/**
 * @Author cs
 * @Date 2022-11-25 16:57
 */
public interface ListableBeanFactory extends BeanFactory{
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;
    String[] getBeanDefinitionNames();
}
