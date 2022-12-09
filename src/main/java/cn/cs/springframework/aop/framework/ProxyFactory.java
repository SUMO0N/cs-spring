package cn.cs.springframework.aop.framework;

import cn.cs.springframework.aop.AdvisedSupport;

/**
 * @Author cs
 * @Date 2022-12-08 11:49
 */
public class ProxyFactory {
    private AdvisedSupport advised;

    public ProxyFactory(AdvisedSupport advised) {
        this.advised = advised;
    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        if(advised.isProxyTargetClass()) {
            return new Cglib2AopProxy(advised);
        }
        return new JdkDynamicAopProxy(advised);
    }
}
