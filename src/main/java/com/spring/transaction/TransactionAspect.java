package com.spring.transaction;

import com.spring.aop.annotation.Aspect;
import com.spring.aop.annotation.Before;
import com.spring.aop.annotation.Pointcut;
import com.spring.context.annotation.Component;
import com.spring.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hanlizhi
 * @time 2017/9/27 0:32
 */
@Aspect
@Slf4j
@Component
public class TransactionAspect {

    @Pointcut(targetAnnotation = Transactional.class)
    public void pointcut(){
        
    }
    
    @Before("pointcut()")
    public void beginTransaction() {
        
    }
}
