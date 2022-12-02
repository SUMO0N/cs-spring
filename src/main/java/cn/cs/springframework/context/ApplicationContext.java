package cn.cs.springframework.context;

import cn.cs.springframework.beans.factory.HierarchicalBeanFactory;
import cn.cs.springframework.beans.factory.ListableBeanFactory;
import cn.cs.springframework.core.io.ResourceLoader;

/**
 * @Author cs
 * @Date 2022-11-28 17:26
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader,ApplicationEventPublisher {
}
