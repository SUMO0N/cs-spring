package cn.cs.springframework.test.event;

import cn.cs.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * @Author cs
 * @Date 2022-12-01 11:54
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMsg());
    }
}
