package cn.cs.springframework.context;

/**
 * @Author cs
 * @Date 2022-11-30 10:52
 */
public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}
