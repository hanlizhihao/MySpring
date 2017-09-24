package com.spring.context.bean;

/**
 * @author hanlizhi
 * @time 2017/9/25 0:00
 */
public class NamedBeanHolder<T> {

    private final String beanName;

    private final T beanInstance;

    public NamedBeanHolder(String beanName, T beanInstance) {
        this.beanName = beanName;
        this.beanInstance = beanInstance;
    }

    public String getBeanName() {
        return this.beanName;
    }

    public T getBeanInstance() {
        return this.beanInstance;
    }
}
