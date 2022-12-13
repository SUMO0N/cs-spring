package cn.cs.springframework.core.convert.converter;

/**
 * @Author cs
 * @Date 2022-12-13 17:24
 */
public interface ConverterRegistry {
    void addConverter(Converter<?, ?> converter);

    void addConverter(GenericConverter converter);

    void addConverterFactory(ConverterFactory<?, ?> converterFactory);
}
