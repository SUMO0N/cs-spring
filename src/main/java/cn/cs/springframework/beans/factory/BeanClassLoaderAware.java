package cn.cs.springframework.beans.factory;

/**
 * @Author cs
 * @Date 2022-11-29 19:47
 */
public interface BeanClassLoaderAware extends Aware {
    void setBeanClassLoader(ClassLoader classLoader);
}
