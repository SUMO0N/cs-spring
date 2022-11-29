package cn.cs.springframework.context;

import cn.cs.springframework.beans.BeansException;
import cn.cs.springframework.beans.factory.Aware;

/**
 * @Author cs
 * @Date 2022-11-29 19:48
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
