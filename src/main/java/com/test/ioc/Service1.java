package com.test.ioc;

import com.spring.context.annotation.Component;

/**
 * @author hanlizhi
 * @time 2017/9/24 22:12
 */
@Component
public class Service1 {

    public void test() {
        System.out.println("Service1 Method");
    }
}
