package cn.cs.springframework.beans;

/**
 * @Author cs
 * @Date 2022-11-25 11:25
 */
public class BeansException extends RuntimeException{

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
