package cn.cs.springframework.context.support;

import cn.cs.springframework.beans.BeansException;
import cn.cs.springframework.beans.factory.config.BeanPostProcessor;
import cn.cs.springframework.context.ApplicationContext;
import cn.cs.springframework.context.ApplicationContextAware;

/**
 * @Author cs
 * @Date 2022-11-29 19:48
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware)bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
