package com.test.ioc;

import com.spring.annotation.Autowired;
import com.spring.annotation.Component;

/**
 * @author hanlizhi
 * @time 2017/9/24 22:14
 */
@Component
public class Service2 {

    @Autowired
    private Service1 service1;

    public void test(){
        if (service1!=null) service1.test();
    }
}
