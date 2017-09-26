package com.spring.context;

import com.spring.annotation.ComponentScan;
import com.spring.context.bean.BeanFactory;
import com.spring.context.bean.GenericBeanFactory;
import com.spring.util.ClassUtil;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator 
 * @create 2017-9-6 0:39:27
 */
@Slf4j
public class AnnotationConfigApplicationContext implements ApplicationContext{

    private Map<String, Object> objectMap = new ConcurrentHashMap<>();

    private Map<String, Class> classMap = new ConcurrentHashMap<>();

    private BeanFactory genericBeanFactory;

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
        genericBeanFactory = GenericBeanFactory.getInstance();
        if (ClassUtil.isConfigurationClass(config)) {
            log.info("s");
            ComponentScan componentScan = ClassUtil.getComponentScanAnnotation(config);
            Class<?>[] basePackagesClass = componentScan.basePackageClasses();
            for (int i=0;i<basePackagesClass.length;i++) {
                genericBeanFactory.createBean(basePackagesClass[i]);
            }
        }
    }

    public AnnotationConfigApplicationContext(Class<?> config) {
        initApplicationContext(config);
    }

}
