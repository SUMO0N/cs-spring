package cn.cs.springframework.test.event;

import cn.cs.springframework.context.ApplicationListener;
import cn.cs.springframework.context.event.ContextRefreshedEvent;

/**
 * @Author cs
 * @Date 2022-12-01 11:58
 */
public class ContextRefreshEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }
}
