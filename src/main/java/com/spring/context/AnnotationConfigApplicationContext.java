package com.spring.context;

import com.spring.context.annotation.Autowired;
import com.spring.context.annotation.ComponentScan;
import com.spring.aop.AopContext;
import com.spring.aop.annotation.Aspect;
import com.spring.context.bean.BeanFactory;
import com.spring.context.bean.GenericBeanFactory;
import com.spring.util.ClassUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author Administrator 
 * @create 2017-9-6 0:39:27
 */
@Slf4j
public class AnnotationConfigApplicationContext implements ApplicationContext{

    private BeanFactory genericBeanFactory;

    private AopContext aopContext;

    private ArrayList<Class> aspectClass;

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
        aspectClass = new ArrayList<>();

        if (ClassUtil.isConfigurationClass(config)) {
            log.info("s");
            ComponentScan componentScan = ClassUtil.getComponentScanAnnotation(config);
            Class<?>[] basePackagesClass = componentScan.basePackageClasses();
            for (Class<?> baseClass : basePackagesClass) {
                genericBeanFactory.createBean(baseClass);
                if (isAspectAnnotaedClass(baseClass)) {
                    aspectClass.add(baseClass);
                }
            }
            try {
                autoWired(basePackagesClass);
            } catch (Exception e) {
                log.error("Application Context Init Exception",e);
                System.exit(0);
            }
            aopContext = AopContext.getInstance();
            aopContext.startContextByAspectClass(aspectClass.get(0), genericBeanFactory.getMap());
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

    //接受一个class，判断是否有@Aspect
    private boolean isAspectAnnotaedClass(Class<?> clz) {
        Aspect annotation = clz.getAnnotation(Aspect.class);
        return annotation != null;
    }

}
