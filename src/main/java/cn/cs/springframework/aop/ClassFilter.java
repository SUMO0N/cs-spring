package cn.cs.springframework.aop;

/**
 * @Author cs
 * @Date 2022-12-02 10:01
 */
public interface ClassFilter {
    boolean matches(Class<?> clazz);
}
