package cn.cs.springframework.core.convert.support;

import cn.cs.springframework.core.convert.converter.ConverterRegistry;

/**
 * @Author cs
 * @Date 2022-12-13 17:24
 */
public class DefaultConversionService extends GenericConversionService {

    public DefaultConversionService() {
        addDefaultConverters(this);
    }

    public static void addDefaultConverters(ConverterRegistry converterRegistry) {
        converterRegistry.addConverterFactory(new StringToNumberConverterFactory());
    }
}
