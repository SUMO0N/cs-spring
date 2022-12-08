package cn.cs.springframework.aop;

/**
 * @Author cs
 * @Date 2022-12-02 10:00
 */
public interface Pointcut {
    ClassFilter getClassFilter();
    MethodMatcher getMethodMatcher();
}
