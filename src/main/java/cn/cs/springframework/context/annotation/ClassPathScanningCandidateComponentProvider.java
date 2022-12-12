package cn.cs.springframework.context.annotation;

import cn.cs.springframework.beans.factory.config.BeanDefinition;
import cn.cs.springframework.stereotype.Component;
import cn.hutool.core.util.ClassUtil;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author cs
 * @Date 2022-12-12 10:18
 */
public class ClassPathScanningCandidateComponentProvider {
    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
