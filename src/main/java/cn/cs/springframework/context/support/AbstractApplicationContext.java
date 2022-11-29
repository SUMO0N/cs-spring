package cn.cs.springframework.context.support;

import cn.cs.springframework.beans.BeansException;
import cn.cs.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.cs.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.cs.springframework.beans.factory.config.BeanPostProcessor;
import cn.cs.springframework.context.ConfigurableApplicationContext;
import cn.cs.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * @Author cs
 * @Date 2022-11-28 17:27
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    @Override
    public void refresh() {
        // 创建bean工厂，并加载BeanDefinition
        refreshBeanFactory();

        // 获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 添加ApplicationContextAwareProcessor, 使得所有实现ApplicationContextAware都感知到当前applicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        // 在Bean实例化之前，执行BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessor(beanFactory);

        // BeanPostProcessor 需要提前于其他的bean对象实例化之前执行注册操作
        registryBeanPostProcessors(beanFactory);

        // 提前实例化单例bean对象
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessor(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registryBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public void registryShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        getBeanFactory().destroySingletons();
    }
}
