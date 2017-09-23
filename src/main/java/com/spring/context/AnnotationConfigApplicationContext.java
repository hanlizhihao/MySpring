package com.spring.context;

import com.spring.annotation.ComponentScan;
import com.spring.util.ClassUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator 
 * @create 2017-9-6 0:39:27
 */
public class AnnotationConfigApplicationContext implements ApplicationContext{

    private Map<String, Object> objectMap = new ConcurrentHashMap<String, Object>();

    private Map<String, Class> classMap = new ConcurrentHashMap<String, Class>();

    @Override
    public Object getBean(String beanName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getBean(Class<?> beanClass) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void initApplicationContext(Class<?> config) {
        if (ClassUtil.isConfigurationClass(config)) {
            ComponentScan componentScan = ClassUtil.getComponentScanAnnotation(config);

        }
    }

    AnnotationConfigApplicationContext(Class<?> config) {

    }

}
