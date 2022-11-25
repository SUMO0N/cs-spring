package cn.cs.springframework.uitils;

/**
 * @Author cs
 * @Date 2022-11-25 16:57
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }
        if(cl == null) {
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }
}
