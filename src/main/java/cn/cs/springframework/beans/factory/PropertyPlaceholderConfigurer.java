package cn.cs.springframework.beans.factory;

import cn.cs.springframework.beans.BeansException;
import cn.cs.springframework.beans.PropertyValue;
import cn.cs.springframework.beans.PropertyValues;
import cn.cs.springframework.beans.factory.config.BeanDefinition;
import cn.cs.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.cs.springframework.core.io.DefaultResourceLoader;
import cn.cs.springframework.core.io.Resource;
import cn.cs.springframework.uitil.StringValueResolver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author cs
 * @Date 2022-12-12 10:21
 * 处理占位符
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {
    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";
    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";
    private String location;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());
            for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    Object value = propertyValue.getValue();
                    if(!(value instanceof String)) continue;
                    value = resolvePlaceholder((String)value, properties);
                    propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), value));
                }
            }
            // 向容器中添加字符串解析器，供解析@Value注解
            PlaceholderResolvingStringValueResolver valueResolver = new PlaceholderResolvingStringValueResolver(properties);
            beanFactory.addEmbeddedValueResolver(valueResolver);

        } catch (IOException e) {
            throw new BeansException("Could not load properties", e);
        }
    }

    private String resolvePlaceholder(String value, Properties properties) {
        String valStr = value;
        StringBuilder buffer = new StringBuilder(valStr);
        int startIdx = valStr.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
        int endIdx = valStr.lastIndexOf(DEFAULT_PLACEHOLDER_SUFFIX);
        if(startIdx != -1 && endIdx != -1 && startIdx < endIdx) {
            String propKey = valStr.substring(startIdx + 2, endIdx);
            String propVal = properties.getProperty(propKey);
            buffer.replace(startIdx, endIdx + 1, propVal);
        }
        return buffer.toString();
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private class PlaceholderResolvingStringValueResolver implements StringValueResolver {
        private final Properties properties;

        public PlaceholderResolvingStringValueResolver(Properties properties) {
            this.properties = properties;
        }

        @Override
        public String resolveStringValue(String strVal) {
            return PropertyPlaceholderConfigurer.this.resolvePlaceholder(strVal, properties);
        }
    }
}
