package com.test.ioc;

import com.spring.context.annotation.ComponentScan;
import com.spring.context.annotation.Configuration;

/**
 * @author hanlizhi
 * @time 2017/9/24 19:02
 */
@Configuration
@ComponentScan(basePackageClasses = {Service1.class,Service2.class})
public class MyConfig {
}
