package com.spring.transaction;

/**
 * @author hanlizhi
 * @time 2017/9/26 23:09
 */
public interface TransactionAttribute extends TransactionDefinition {

    String getQualifier();

    boolean rollbackOn(Throwable ex);
}
