package cn.cs.springframework.context.support;

import cn.cs.springframework.beans.factory.FactoryBean;
import cn.cs.springframework.beans.factory.InitializingBean;
import cn.cs.springframework.core.convert.ConversionService;
import cn.cs.springframework.core.convert.converter.Converter;
import cn.cs.springframework.core.convert.converter.ConverterFactory;
import cn.cs.springframework.core.convert.converter.ConverterRegistry;
import cn.cs.springframework.core.convert.converter.GenericConverter;
import cn.cs.springframework.core.convert.support.DefaultConversionService;
import cn.cs.springframework.core.convert.support.GenericConversionService;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

/**
 * @Author cs
 * @Date 2022-12-13 19:50
 */
public class ConversionServiceFactoryBean implements FactoryBean<ConversionService>, InitializingBean {
    @Nullable
    private Set<?> converters;
    @Nullable
    private GenericConversionService conversionService;

    @Override
    public ConversionService getObject() throws Exception {
        return conversionService;
    }

    @Override
    public Class<?> getObjectType() {
        return conversionService.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() {
        DefaultConversionService conversionService = new DefaultConversionService();
        registerConverters(converters, conversionService);
    }

    private void registerConverters(Set<?> converters, ConverterRegistry converterRegistry) {
        if(converters != null) {
            for (Object converter : converters) {
                if(converter instanceof GenericConverter) {
                    converterRegistry.addConverter((GenericConverter)converter);
                } else if(converter instanceof Converter<?, ?>) {
                    converterRegistry.addConverter((Converter<?, ?>)converter);
                } else if(converter instanceof ConverterFactory<?, ?>) {
                    converterRegistry.addConverterFactory((ConverterFactory<?, ?>)converter);
                } else {
                    throw new IllegalArgumentException("Each converter object must implement one of the " +
                            "Converter, ConverterFactory, or GenericConverter interfaces");
                }
            }
        }
    }

    public void setConverters(Set<?> converters) {
        this.converters = converters;
    }
}
