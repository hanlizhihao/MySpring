package com.test;

import com.spring.context.AnnotationConfigApplicationContext;
import com.spring.context.ApplicationContext;

/**
 * @author hanlizhi
 * @time 2017/9/24 19:00
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

    }
}
