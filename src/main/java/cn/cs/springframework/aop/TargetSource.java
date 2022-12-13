package cn.cs.springframework.aop;

import cn.cs.springframework.uitil.ClassUtils;

/**
 * @Author cs
 * @Date 2022-12-02 10:08
 */
public class TargetSource {
    private Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        Class<?> clazz = target.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        return clazz.getInterfaces();
    }

    public Object getTarget() {
        return target;
    }
}
