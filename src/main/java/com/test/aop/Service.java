package com.test.aop;

import com.spring.context.annotation.Component;
import com.spring.aop.Advice;

/**
 * @author hanlizhi
 * @create 2017-09-26 14:56
 */
@Component
public class Service implements Advice {

    @Override
    @TestPointcut
    public void testFirstMethod() {
        System.out.println("testFirstMethod目标方法被执行");
    }

    @TestPointcut
    @Override
    public void testSecondMethod() {
        System.out.println("testThirdMethod目标方法被执行");
    }
}
