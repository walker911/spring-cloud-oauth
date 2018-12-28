package com.walker.user.config;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.Callable;

/**
 * @author walker
 * @date 2018/12/28
 */
public class HystrixThreadCallable<T> implements Callable<T> {

    private final RequestAttributes attributes;
    private final Callable<T> delegate;
    private String params;

    public HystrixThreadCallable(RequestAttributes attributes, Callable<T> delegate, String params) {
        this.attributes = attributes;
        this.delegate = delegate;
        this.params = params;
    }

    @Override
    public T call() throws Exception {
        try {
            RequestContextHolder.setRequestAttributes(attributes);
            HystrixThreadLocal.threadLocal.set(params);
            return delegate.call();
        } finally {
            RequestContextHolder.resetRequestAttributes();
            HystrixThreadLocal.threadLocal.remove();
        }
    }
}
