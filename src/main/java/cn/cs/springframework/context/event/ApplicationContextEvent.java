package cn.cs.springframework.context.event;

import cn.cs.springframework.context.ApplicationEvent;

/**
 * @Author cs
 * @Date 2022-11-30 10:51
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }
}
