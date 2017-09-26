package com.test.aop;

import com.spring.annotation.ComponentScan;
import com.spring.annotation.Configuration;

/**
 * @author hanlizhi
 * @create 2017-09-26 13:36
 */
@Configuration
@ComponentScan(basePackageClasses = {TestAspect.class, Service.class})
public class AopConfig {

}
