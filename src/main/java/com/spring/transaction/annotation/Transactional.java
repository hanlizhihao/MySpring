package com.spring.transaction.annotation;

import java.lang.annotation.*;

/**
 * @author hanlizhi
 * @time 2017/9/26 23:02
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Transactional {

    Class<? extends Throwable>[] rollbackFor() default {};
}
