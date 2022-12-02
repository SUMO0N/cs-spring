package cn.cs.springframework.test.event;

import cn.cs.springframework.context.event.ApplicationContextEvent;

/**
 * @Author cs
 * @Date 2022-12-01 11:53
 */
public class CustomEvent extends ApplicationContextEvent {
    private long id;
    private String msg;

    public CustomEvent(Object source, long id, String msg) {
        super(source);
        this.id = id;
        this.msg = msg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
