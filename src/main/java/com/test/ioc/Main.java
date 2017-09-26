package com.test.ioc;

import com.spring.context.AnnotationConfigApplicationContext;

/**
 * @author hanlizhi
 * @time 2017/9/24 19:00
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Service2 service2 = (Service2) context.getBean("Service2");
        service2.test();
    }
}
