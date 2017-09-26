package com.spring.transaction;

import java.io.Serializable;

/**
 * @author hanlizhi
 * @time 2017/9/27 0:12
 */
public class SpringTransactionAnnotationParser implements TransactionAnnotationParser, Serializable {
    @Override
    public TransactionAttribute parseTransactionAnnotation(Class<?> annotation) {
        return null;
    }
}
