package com.walker.user.config;

import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.Callable;

/**
 * @author walker
 * @date 2018/12/28
 */
public class AuthorizationConcurrencyStrategy extends HystrixConcurrencyStrategy {

    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        return new HystrixThreadCallable<>(RequestContextHolder.getRequestAttributes(), callable,
                HystrixThreadLocal.threadLocal.get());
    }
}
