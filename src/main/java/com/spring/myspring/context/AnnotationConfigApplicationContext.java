package com.spring.myspring.context;

/**
 * @author Administrator 
 * @create 2017-9-6 0:39:27
 */
public class AnnotationConfigApplicationContext implements ApplicationContext{

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
        
    }

}
