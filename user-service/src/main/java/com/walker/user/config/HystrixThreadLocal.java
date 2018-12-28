package com.walker.user.config;

/**
 * @author walker
 * @date 2018/12/28
 */
public class HystrixThreadLocal {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
}
