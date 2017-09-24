package com.spring.context.exception;

/**
 * @author hanlizhi
 * @time 2017/9/24 22:24
 */
public class NoSuchBeanDefinitionException extends BeansException {
    public NoSuchBeanDefinitionException(String msg) {
        super("No bean named '" + msg + "' available");
    }

    public NoSuchBeanDefinitionException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
