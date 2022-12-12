package cn.cs.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * @Author cs
 * @Date 2022-12-12 10:19
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {
    String value() default "";
}
