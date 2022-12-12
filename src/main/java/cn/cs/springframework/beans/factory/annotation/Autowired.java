package cn.cs.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @Author cs
 * @Date 2022-12-12 15:48
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD})
public @interface Autowired {
}
