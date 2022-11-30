package cn.cs.springframework.beans.factory;

/**
 * @Author cs
 * @Date 2022-11-29 20:50
 */
public interface FactoryBean<T> {
    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
