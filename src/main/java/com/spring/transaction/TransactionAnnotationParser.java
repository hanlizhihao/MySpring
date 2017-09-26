package com.spring.transaction;

/**
 * @author hanlizhi
 * @time 2017/9/26 23:05
 */
public interface TransactionAnnotationParser {

    TransactionAttribute parseTransactionAnnotation(Class<?> annotation);

}
