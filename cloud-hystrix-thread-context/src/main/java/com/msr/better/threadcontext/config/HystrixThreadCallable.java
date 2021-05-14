package com.msr.better.threadcontext.config;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.Callable;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-05-14 22:51
 **/
public class HystrixThreadCallable<S>implements Callable<S> {
    private final RequestAttributes requestAttributes;
    private final Callable<S> delegate;
    private String params;

    public HystrixThreadCallable(Callable<S> callable, RequestAttributes requestAttributes,String params) {
        this.delegate = callable;
        this.requestAttributes = requestAttributes;
        this.params = params;
    }

    @Override
    public S call() throws Exception {
        try {
            RequestContextHolder.setRequestAttributes(requestAttributes);
            HystrixThreadLocal.threadLocal.set(params);
            return delegate.call();
        } finally {
            RequestContextHolder.resetRequestAttributes();
            HystrixThreadLocal.threadLocal.remove();
        }
    }
}
