package cn.cs.springframework.test;

import cn.cs.springframework.aop.AdvisedSupport;
import cn.cs.springframework.aop.TargetSource;
import cn.cs.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.cs.springframework.aop.framework.Cglib2AopProxy;
import cn.cs.springframework.aop.framework.JdkDynamicAopProxy;
import cn.cs.springframework.test.bean.IUserService;
import cn.cs.springframework.test.bean.UserService;
import cn.cs.springframework.test.bean.UserServiceInterceptor;

/**
 * @Author cs
 * @Date 2022-11-25 11:17
 */
public class ApiTest {
    public static void main(String[] args) {
        UserService userService = new UserService();
        AdvisedSupport advised = new AdvisedSupport();
        advised.setMethodInterceptor(new UserServiceInterceptor());
        advised.setTargetSource(new TargetSource(userService));
        advised.setMethodMatcher(new AspectJExpressionPointcut("execution(* cn.cs.springframework.test.bean.IUserService.*(..))"));
        IUserService proxyJdk = (IUserService)new JdkDynamicAopProxy(advised).getProxy();
        System.out.println(proxyJdk.query());
        IUserService proxyCglib = (IUserService)new Cglib2AopProxy(advised).getProxy();
        System.out.println(proxyCglib.query());
    }
}
