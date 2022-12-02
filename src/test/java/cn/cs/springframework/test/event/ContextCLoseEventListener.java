package cn.cs.springframework.test.event;

import cn.cs.springframework.context.ApplicationListener;
import cn.cs.springframework.context.event.ContextClosedEvent;

/**
 * @Author cs
 * @Date 2022-12-01 11:57
 */
public class ContextCLoseEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }
}
