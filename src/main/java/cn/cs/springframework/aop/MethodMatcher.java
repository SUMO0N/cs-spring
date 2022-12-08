package cn.cs.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Author cs
 * @Date 2022-12-02 10:01
 */
public interface MethodMatcher {
    boolean matches(Method method, Class<?> targetClass);
}
