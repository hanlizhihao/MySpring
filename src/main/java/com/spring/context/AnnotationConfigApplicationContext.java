package com.spring.context;

import com.spring.annotation.Autowired;
import com.spring.annotation.ComponentScan;
import com.spring.context.bean.BeanFactory;
import com.spring.context.bean.GenericBeanFactory;
import com.spring.util.ClassUtil;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator 
 * @create 2017-9-6 0:39:27
 */
@Slf4j
public class AnnotationConfigApplicationContext implements ApplicationContext{

    private BeanFactory genericBeanFactory;

    @Override
    public Object getBean(String beanName) {
        return genericBeanFactory.getBean(beanName);
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
            for (Class<?> basePackagesClas : basePackagesClass) {
                genericBeanFactory.createBean(basePackagesClas);
            }
            try {
                autoWired(basePackagesClass);
            } catch (Exception e) {
                log.error("Application Context Init Exception",e);
                System.exit(0);
            }
        }
    }

    public AnnotationConfigApplicationContext(Class<?> config) {
        initApplicationContext(config);
    }

    private void autoWired(Class<?>... components) throws Exception {
        for (Class<?> component:components) {
            Field[] componentField = component.getDeclaredFields();
            for (Field field:componentField) {
                Autowired annotationComponent = field.getAnnotation(Autowired.class);
                if (annotationComponent != null) {
                    field.setAccessible(true);
                    Object componentObject = genericBeanFactory.getBean(component.getSimpleName());
                    try {
                        field.set(componentObject, genericBeanFactory.getBean(field.getType().getSimpleName()));
                    } catch (IllegalAccessException e) {
                        log.error(component.getName()+"Autowired Error"+field.getType().getSimpleName());
                        throw new Exception("Autowired Exception");
                    }
                }
            }
        }
        log.info("Autowired Success");
    }

}
