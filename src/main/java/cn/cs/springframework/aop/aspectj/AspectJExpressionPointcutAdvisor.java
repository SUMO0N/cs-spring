package cn.cs.springframework.aop.aspectj;

import cn.cs.springframework.aop.Pointcut;
import cn.cs.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @Author cs
 * @Date 2022-12-08 10:41
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {
    // 切面
    private AspectJExpressionPointcut pointcut;
    // 拦截方法
    private Advice advice;
    // 表达式
    private String expression;

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public Pointcut getPointcut() {
        if(pointcut == null) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
