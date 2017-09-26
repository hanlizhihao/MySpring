package com.test.aop;

import com.spring.context.annotation.Component;
import com.spring.aop.annotation.After;
import com.spring.aop.annotation.Aspect;
import com.spring.aop.annotation.Before;
import com.spring.aop.annotation.Pointcut;

/**
 * @author hanlizhi
 * @create 2017-09-26 14:51
 */

@Aspect
@Component
public class TestAspect {

    @Pointcut(targetAnnotation = TestPointcut.class)
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before() {
        System.out.println("前置");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("后置");
    }
}
