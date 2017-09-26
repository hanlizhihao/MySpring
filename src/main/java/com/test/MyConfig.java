package com.test;

import com.spring.annotation.ComponentScan;
import com.spring.annotation.Configuration;

/**
 * @author hanlizhi
 * @time 2017/9/24 19:02
 */
@Configuration
@ComponentScan(basePackageClasses = {Service1.class,Service2.class})
public class MyConfig {
}
