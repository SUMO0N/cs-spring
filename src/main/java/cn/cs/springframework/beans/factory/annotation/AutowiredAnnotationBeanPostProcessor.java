package cn.cs.springframework.beans.factory.annotation;

import cn.cs.springframework.beans.BeansException;
import cn.cs.springframework.beans.PropertyValue;
import cn.cs.springframework.beans.PropertyValues;
import cn.cs.springframework.beans.factory.BeanFactory;
import cn.cs.springframework.beans.factory.BeanFactoryAware;
import cn.cs.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.cs.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import cn.cs.springframework.uitil.ClassUtils;
import cn.hutool.core.bean.BeanUtil;

import java.lang.reflect.Field;

/**
 * @Author cs
 * @Date 2022-12-12 16:27
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor , BeanFactoryAware {
    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        // 处理@Value
        Class<?> clazz = bean.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            Value valueAnnotation = field.getAnnotation(Value.class);
            if(valueAnnotation != null) {
                String value = valueAnnotation.value();
                value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean, field.getName(), value);
            }
        }

        // 处理@Autowired
        for (Field field : declaredFields) {
            Autowired autowired = field.getAnnotation(Autowired.class);
            if(autowired != null) {
                Class<?> fieldType = field.getType();
                String dependentBeanName = null;
                Object dependentBean = null;
                Qualifier qualifier = field.getAnnotation(Qualifier.class);
                if(qualifier != null) {
                    dependentBeanName = qualifier.value();
                    dependentBean = beanFactory.getBean(dependentBeanName, fieldType);
                } else {
                    dependentBean = beanFactory.getBean(fieldType);
                }
                BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
            }
        }
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }


}
