package cn.cs.springframework.aop;

/**
 * @Author cs
 * @Date 2022-12-08 10:47
 */
public interface PointcutAdvisor extends Advisor{
    Pointcut getPointcut();
}
