package com.test.aop;

import com.spring.context.annotation.Component;
import com.spring.aop.Advice;

/**
 * @author hanlizhi
 * @create 2017-09-26 14:56
 */
@Component
public class Service implements Advice {

    @TestPointcut
    public void testMethod(){
        System.out.println("testMethod目标方法被执行");
    }
}
