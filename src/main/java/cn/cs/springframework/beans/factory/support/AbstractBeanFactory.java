package cn.cs.springframework.beans.factory.support;

import cn.cs.springframework.beans.BeansException;
import cn.cs.springframework.beans.factory.FactoryBean;
import cn.cs.springframework.beans.factory.config.BeanDefinition;
import cn.cs.springframework.beans.factory.config.BeanPostProcessor;
import cn.cs.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.cs.springframework.uitil.ClassUtils;
import cn.cs.springframework.uitil.StringValueResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cs
 * @Date 2022-11-25 11:27
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    private List<StringValueResolver> embeddedValueResolvers = new ArrayList<>();

    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        beanPostProcessors.remove(beanPostProcessor);
        beanPostProcessors.add(beanPostProcessor);
    }

    @Override
    public void addEmbeddedValueResolver(StringValueResolver valueResolver) {
        embeddedValueResolvers.add(valueResolver);
    }

    @Override
    public String resolveEmbeddedValue(String value) {
        String result = value;
        for (StringValueResolver resolver : embeddedValueResolvers) {
            result = resolver.resolveStringValue(result);
        }
        return result;
    }

    protected <T> T doGetBean(String name, Object[] args) throws BeansException {
        Object sharedInstance = super.getSingleton(name);
        if(sharedInstance != null) {
            return (T) getObjectForBeanInstance(sharedInstance, name);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if(!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }
        Object object = getCachedObjectForFactoryBean(beanName);
        if(object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getCachedObjectForFactoryBean(factoryBean, beanName);
        }
        return object;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
