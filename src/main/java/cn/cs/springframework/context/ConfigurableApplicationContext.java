package cn.cs.springframework.context;

import cn.cs.springframework.beans.BeansException;

/**
 * @Author cs
 * @Date 2022-11-28 17:26
 */
public interface ConfigurableApplicationContext extends ApplicationContext{
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();
}
