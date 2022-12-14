package cn.cs.springframework.beans.factory.config;

import cn.cs.springframework.beans.BeansException;
import cn.cs.springframework.beans.factory.BeanFactory;

/**
 * @Author cs
 * @Date 2022-11-25 16:57
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
