package cn.cs.springframework.core.io;

/**
 * @Author cs
 * @Date 2022-11-25 17:00
 */
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
