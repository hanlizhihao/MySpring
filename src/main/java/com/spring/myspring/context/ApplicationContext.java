package com.spring.myspring.context;



/**
 * @author Administrator 
 * @create 2017-9-6 0:16:19
 */
public interface ApplicationContext {
    
    Object getBean(String beanName);
    
    Object getBean(Class<?> beanClass);
    
    void initApplicationContext(Class<?> config);
    
}
