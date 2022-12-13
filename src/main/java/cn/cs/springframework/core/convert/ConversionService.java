package cn.cs.springframework.core.convert;

import org.jetbrains.annotations.Nullable;

/**
 * @Author cs
 * @Date 2022-12-13 17:22
 */
public interface ConversionService {
    boolean canConvert(@Nullable Class<?> sourceType, Class<?> targetType);

    <T> T convert(Object source, Class<T> targetType);
}
