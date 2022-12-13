package cn.cs.springframework.beans.factory.config;

import cn.cs.springframework.beans.factory.HierarchicalBeanFactory;
import cn.cs.springframework.core.convert.ConversionService;
import cn.cs.springframework.uitil.StringValueResolver;
import org.jetbrains.annotations.Nullable;

/**
 * @Author cs
 * @Date 2022-11-25 16:57
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void destroySingletons();

    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    String resolveEmbeddedValue(String value);

    void setConversionService(ConversionService conversionService);

    @Nullable
    ConversionService getConversionService();
}
