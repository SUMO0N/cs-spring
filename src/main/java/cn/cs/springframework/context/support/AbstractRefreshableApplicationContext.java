package cn.cs.springframework.context.support;

import cn.cs.springframework.beans.BeansException;
import cn.cs.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.cs.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author cs
 * @Date 2022-11-28 17:27
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
