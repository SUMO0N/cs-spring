package cn.cs.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Author cs
 * @Date 2022-12-08 10:46
 */
public interface MethodBeforeAdvice extends BeforeAdvice {
    void before(Method method, Object[] args, Object target) throws Throwable;
}
