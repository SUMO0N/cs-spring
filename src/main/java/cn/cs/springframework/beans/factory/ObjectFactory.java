package cn.cs.springframework.beans.factory;

import cn.cs.springframework.beans.BeansException;

/**
 * @Author cs
 * @Date 2022-12-13 11:40
 */
public interface ObjectFactory<T> {
    T getObject() throws BeansException;
}
