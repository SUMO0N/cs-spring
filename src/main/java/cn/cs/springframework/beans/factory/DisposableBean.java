package cn.cs.springframework.beans.factory;

/**
 * @Author cs
 * @Date 2022-11-29 10:22
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
