package cn.cs.springframework.context;

import java.util.EventListener;

/**
 * @Author cs
 * @Date 2022-11-30 10:52
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    void onApplicationEvent(E event);
}
