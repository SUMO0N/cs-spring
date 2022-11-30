package cn.cs.springframework.test.bean;

import cn.cs.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author cs
 * @Date 2022-11-29 21:16
 */
public class ProxyBeanFactory implements FactoryBean<IUserDao> {
    @Override
    public IUserDao getObject() throws Exception {
        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDao.class},
                ((proxy, method, args) -> {
                    Map<String, String> hashMap = new HashMap<>();
                    hashMap.put("10001", "cs");
                    hashMap.put("10002", "八杯水");
                    hashMap.put("10003", "阿毛");
                    return "你被代理了 " + method.getName() + "：" + hashMap.get(args[0].toString());
                }));
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
