package com.spring.util;

import com.spring.annotation.ComponentScan;
import com.spring.annotation.Configuration;

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

    public static ComponentScan getComponentScanAnnotation( Class<?> configClass) {
        return configClass.getAnnotation(ComponentScan.class);
    }

    public static ConcurrentHashMap<String, Object> getObjectMapByComponentScan(ComponentScan componentScan) {
        ConcurrentHashMap<String, Object> objectConcurrentHashMap = new ConcurrentHashMap<>();
        return null;
    }

}
