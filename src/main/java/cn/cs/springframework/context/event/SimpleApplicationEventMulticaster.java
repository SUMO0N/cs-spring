package cn.cs.springframework.context.event;

import cn.cs.springframework.beans.factory.BeanFactory;
import cn.cs.springframework.context.ApplicationEvent;
import cn.cs.springframework.context.ApplicationListener;

/**
 * @Author cs
 * @Date 2022-11-30 10:53
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicasterEvent(ApplicationEvent event) {
        for (ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
