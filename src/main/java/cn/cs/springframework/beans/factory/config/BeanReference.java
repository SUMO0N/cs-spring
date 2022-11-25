package cn.cs.springframework.beans.factory.config;

/**
 * @Author cs
 * @Date 2022-11-25 16:07
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
