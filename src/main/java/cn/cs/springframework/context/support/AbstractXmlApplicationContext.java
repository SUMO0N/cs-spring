package cn.cs.springframework.context.support;

import cn.cs.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.cs.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Author cs
 * @Date 2022-11-28 17:27
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if(configLocations != null) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
