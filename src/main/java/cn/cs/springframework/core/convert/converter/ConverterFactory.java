package cn.cs.springframework.core.convert.converter;

/**
 * @Author cs
 * @Date 2022-12-13 17:23
 */
public interface ConverterFactory<S, R> {
    <T extends R> Converter<S, T> getConverter(Class<T> targetType);
}
