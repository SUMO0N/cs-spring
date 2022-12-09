package cn.cs.springframework.test.bean;

import cn.cs.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author cs
 * @Date 2022-12-08 15:08
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法:" + method.getName());
    }
}
