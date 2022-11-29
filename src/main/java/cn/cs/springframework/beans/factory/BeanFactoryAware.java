package cn.cs.springframework.beans.factory;

import cn.cs.springframework.beans.BeansException;

/**
 * @Author cs
 * @Date 2022-11-29 19:47
 */
public interface BeanFactoryAware extends Aware {
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
