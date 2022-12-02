package cn.cs.springframework.context;

import java.util.EventObject;

/**
 * @Author cs
 * @Date 2022-11-30 10:52
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
