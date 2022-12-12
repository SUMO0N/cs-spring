package cn.cs.springframework.context.annotation;

import cn.cs.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import cn.cs.springframework.beans.factory.config.BeanDefinition;
import cn.cs.springframework.beans.factory.support.BeanDefinitionRegistry;
import cn.cs.springframework.stereotype.Component;
import cn.hutool.core.util.StrUtil;

import java.util.Set;

/**
 * @Author cs
 * @Date 2022-12-12 10:18
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {
    private BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void doScan(String... basePackages) {
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for (BeanDefinition beanDefinition : candidates) {
                String beanScope = resolveBeanScope(beanDefinition);
                if(StrUtil.isNotEmpty(beanScope)) {
                    beanDefinition.setScope(beanScope);
                }
                registry.registerBeanDefinition(determineBeanName(beanDefinition), beanDefinition);
            }
        }
        registry.registerBeanDefinition("cn.cs.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor",
                new BeanDefinition(AutowiredAnnotationBeanPostProcessor.class));
    }

    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Component component = beanClass.getAnnotation(Component.class);
        String value = component.value();
        if(StrUtil.isBlank(value)) {
            value = StrUtil.lowerFirst(beanClass.getSimpleName());
        }
        return value;
    }

    private String resolveBeanScope(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        if(scope != null) return scope.value();
        return null;
    }
}
