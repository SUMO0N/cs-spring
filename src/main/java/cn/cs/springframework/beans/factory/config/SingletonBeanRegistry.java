package cn.cs.springframework.beans.factory.config;

/**
 * @Author cs
 * @Date 2022-11-25 11:26
 */
public interface SingletonBeanRegistry{
    Object getSingleton(String beanName);
}
