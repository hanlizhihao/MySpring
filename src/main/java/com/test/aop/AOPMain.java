package com.test.aop;

import com.spring.aop.Advice;
import com.spring.context.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hanlizhi
 * @create 2017-09-26 13:36
 */

public class AOPMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        Advice service = (Advice) context.getBean("Service");
        service.testFirstMethod();

    }
}
