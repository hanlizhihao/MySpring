package com.spring.context.bean;

import com.spring.context.exception.BeansException;
import com.spring.context.exception.NoSuchBeanDefinitionException;

import javax.naming.NameAlreadyBoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hanlizhi
 * @time 2017/9/24 22:39
 */
public class GenericBeanFactory implements BeanFactory {

    private Map<String, NamedBeanHolder> map = new ConcurrentHashMap<>(10);

    private GenericBeanFactory() {

    }

    public static GenericBeanFactory getInstance() {
        return GenericBeanFactoryHolder.genericBeanFactory;
    }

    private static class GenericBeanFactoryHolder {
        private static final GenericBeanFactory genericBeanFactory = new GenericBeanFactory();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return null;
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return null;
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws BeansException {
        return null;
    }

    @Override
    public boolean containsBean(String name) {
        return false;
    }

    @Override
    public boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return false;
    }

    @Override
    public NamedBeanHolder<?> createBean(Class<?> clz) {
        NamedBeanHolder beanHolder = null;
        try {
            if (clz == null) {
                throw new BeansException(clz.getSimpleName() + "is null");
            }
            beanHolder = (NamedBeanHolder) clz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return beanHolder;
    }
}