package cn.cs.springframework.beans.factory.config;

import cn.cs.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @Author cs
 * @Date 2022-11-25 16:57
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void destroySingletons();
}
