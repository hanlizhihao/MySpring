package com.spring.aop;

import com.spring.aop.annotation.Pointcut;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author hanlizhi
 * @create 2017-09-26 15:57
 */
@Slf4j
public class AopContext {

    private String needProxyClassKey;

    public static AopContext getInstance(){
        return AopContextHolder.aop;
    }

    private ProxyFactoryBean proxyFactoryBean;

    private AopContext(){
        proxyFactoryBean = new ProxyFactoryBean();
    }
    private static class AopContextHolder{

        private static final AopContext aop = new AopContext();
    }

    public void startContextByAspectClass(Class<?> aspectClass, Map<String,Object> beans) {
        proxyFactoryBean.setAspectClass(aspectClass);
        Method[] methods = aspectClass.getMethods();
        Pointcut pointcut = null;
        for (Method method:methods) {
            if (method.getAnnotation(Pointcut.class) != null) {
                pointcut = method.getAnnotation(Pointcut.class);
                break;
            }
        }
        if (pointcut == null) {
            throw new AspectException("Can not find PointCut Annotation Method");
        }
        Class targetAnnotations = pointcut.targetAnnotation();
        log.info(targetAnnotations.getName());
        for (Map.Entry<String, Object> entry:beans.entrySet()) {
            Object value = entry.getValue();
            Method[] tempMethod = value.getClass().getDeclaredMethods();
            if (Stream.of(tempMethod).anyMatch(method -> method.getAnnotation(targetAnnotations)!=null)) {
                proxyFactoryBean.setTarget(value);
                needProxyClassKey = entry.getKey();
            }
        }
        if (proxyFactoryBean.getTarget() == null) {
            log.error(targetAnnotations.getName()+" is not used");
            return;
        }

        beans.put(needProxyClassKey, getProxy());
    }

    public Object getProxy() {
        return proxyFactoryBean.getProxyBean();
    }
}
