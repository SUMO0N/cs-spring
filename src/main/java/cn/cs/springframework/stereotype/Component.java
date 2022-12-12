package cn.cs.springframework.stereotype;

import java.lang.annotation.*;

/**
 * @Author cs
 * @Date 2022-12-12 10:58
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
    String value() default "";
}
