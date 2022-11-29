package cn.cs.springframework.beans.factory;

/**
 * @Author cs
 * @Date 2022-11-29 10:22
 */
public interface InitializingBean {
    void afterPropertiesSet();
}
