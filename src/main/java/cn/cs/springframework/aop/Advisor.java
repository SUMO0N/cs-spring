package cn.cs.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @Author cs
 * @Date 2022-12-08 10:46
 */
public interface Advisor {
    Advice getAdvice();
}
