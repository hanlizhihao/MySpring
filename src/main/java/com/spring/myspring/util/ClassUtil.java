package com.spring.myspring.util;

import com.spring.myspring.annotation.ComponentScan;
import com.spring.myspring.annotation.Configuration;
import com.sun.istack.internal.NotNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hanlizhi
 * @create 2017-09-06 9:03
 */

public class ClassUtil {

    public static boolean isConfigurationClass(Class<?> configClass) throws RuntimeException {
        if (configClass == null) {
            throw new RuntimeException("ConfigClass is Null");
        }
        return configClass.getAnnotation(Configuration.class) != null;
    }

    public static ComponentScan getComponentScanAnnotation(@NotNull Class<?> configClass) {
        return configClass.getAnnotation(ComponentScan.class);
    }

    public static ConcurrentHashMap<String, Object> getObjectMapByComponentScan(ComponentScan componentScan) {
        ConcurrentHashMap<String, Object> objectConcurrentHashMap = new ConcurrentHashMap<String, Object>();
        return null;
    }

}
