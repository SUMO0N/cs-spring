package cn.cs.springframework.aop.framework.autoproxy;

import cn.cs.springframework.aop.AdvisedSupport;
import cn.cs.springframework.aop.Advisor;
import cn.cs.springframework.aop.Pointcut;
import cn.cs.springframework.aop.TargetSource;
import cn.cs.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import cn.cs.springframework.aop.framework.ProxyFactory;
import cn.cs.springframework.beans.BeansException;
import cn.cs.springframework.beans.factory.BeanFactory;
import cn.cs.springframework.beans.factory.BeanFactoryAware;
import cn.cs.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import cn.cs.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.Collection;

/**
 * @Author cs
 * @Date 2022-12-08 10:45
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Class<?> beanClass, String beanName) throws BeansException {

        if(isInfrastructureClass(beanClass)) return null;

        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            if(!advisor.getPointcut().getClassFilter().matches(beanClass)) continue;
            AdvisedSupport advised = new AdvisedSupport();

            TargetSource targetSource = null;
            try {
                targetSource = new TargetSource(beanClass.getConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
            advised.setTargetSource(targetSource);
            advised.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            advised.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advised.setProxyTargetClass(true);
            return new ProxyFactory(advised).getProxy();
        }
        return null;
    }

    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advisor.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advice.class.isAssignableFrom(beanClass);
    }
}
