package cn.cs.springframework.context.event;

import cn.cs.springframework.context.ApplicationEvent;
import cn.cs.springframework.context.ApplicationListener;

/**
 * @Author cs
 * @Date 2022-11-30 10:53
 */
public interface ApplicationEventMulticaster {
    void addApplicationListener(ApplicationListener<?> listener);
    void removeApplicationListener(ApplicationListener<?> listener);
    void multicasterEvent(ApplicationEvent event);
}
