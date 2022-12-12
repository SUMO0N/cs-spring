package cn.cs.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @Author cs
 * @Date 2022-12-12 15:49
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {
    String value() default "";
}
