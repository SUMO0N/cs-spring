package cn.cs.springframework.core.convert.converter;

/**
 * @Author cs
 * @Date 2022-12-13 17:21
 */
public interface Converter<S, T> {
    T convert(S source);
}
