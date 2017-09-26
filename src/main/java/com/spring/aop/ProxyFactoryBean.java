package com.spring.aop;

import com.spring.aop.annotation.After;
import com.spring.aop.annotation.Aspect;
import com.spring.aop.annotation.Before;
import com.spring.aop.annotation.Pointcut;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hanlizhi
 * @create 2017-09-26 15:51
 */
@Data
@Slf4j
public class ProxyFactoryBean {

    private Class<?> aspectClass;

    private Object target;

    private Method beforeMethod;

    private Method afterMethod;


    //生成动态代理类对象
    public Object getProxyBean() {
        Method[] aspectMethods = aspectClass.getDeclaredMethods();
        for (Method method: aspectMethods) {
            if (method.getAnnotation(Before.class) != null) {
                beforeMethod = method;
            } else if (method.getAnnotation(After.class) != null) {
                afterMethod = method;
            }
        }
        if (beforeMethod == null ||afterMethod == null) {
            throw new AspectException("@Before and @After is all need to used");
        }
        log.info(aspectClass.getName());
        Object proxyInstance = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    beforeMethod.invoke(aspectClass.newInstance());
                    Object retVal = method.invoke(target, args);
                    afterMethod.invoke(aspectClass.newInstance());
                    return retVal;
                }
        );
        return proxyInstance;
    }
}
