package com.spring.context.exception;

/**
 * @author hanlizhi
 * @time 2017/9/24 22:20
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
