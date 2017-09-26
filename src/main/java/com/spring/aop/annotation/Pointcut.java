package com.spring.aop.annotation;

import java.lang.annotation.*;

/**
 * @author hanlizhi
 * @create 2017-09-26 13:31
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Pointcut {

    String value() default "";

    String argNames() default "";

    Class targetAnnotation() ;
}
