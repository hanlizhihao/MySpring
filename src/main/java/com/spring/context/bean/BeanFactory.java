package com.spring.context.bean;

import com.spring.context.exception.BeansException;
import com.spring.context.exception.NoSuchBeanDefinitionException;

import java.util.Map;

/**
 * @author hanlizhi
 * @time 2017/9/24 22:19
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    <T> T getBean(Class<T> requiredType) throws BeansException;

    boolean containsBean(String name);

    boolean isSingleton(String name) throws NoSuchBeanDefinitionException;

    void createBean(Class<?> clz);

    Map getMap();
}
