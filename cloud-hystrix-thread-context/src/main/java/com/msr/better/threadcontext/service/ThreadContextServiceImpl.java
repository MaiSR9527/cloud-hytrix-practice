package com.msr.better.threadcontext.service;

import com.msr.better.threadcontext.config.HystrixThreadLocal;
import com.msr.better.threadcontext.controller.ThreadContextController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-05-14 22:56
 **/
@Service
public class ThreadContextServiceImpl implements IThreadContextService{
    private static final Logger log = LoggerFactory.getLogger(ThreadContextController.class);

    @HystrixCommand
    public String getUser(Integer id) {
        log.info("ThreadContextService, Current thread : " + Thread.currentThread().getId());
        log.info("ThreadContextService, ThreadContext object : " + HystrixThreadLocal.threadLocal.get());
        log.info("ThreadContextService, RequestContextHolder : " + RequestContextHolder.currentRequestAttributes().getAttribute("userId", RequestAttributes.SCOPE_REQUEST).toString());
        return "Success";
    }
}
