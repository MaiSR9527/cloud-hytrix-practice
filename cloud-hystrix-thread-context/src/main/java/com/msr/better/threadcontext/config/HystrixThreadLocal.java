package com.msr.better.threadcontext.config;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-05-14 22:54
 **/
public class HystrixThreadLocal {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
}
