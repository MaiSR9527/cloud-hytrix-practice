package com.msr.better.service.impl;

import com.msr.better.api.OrderServiceApi;
import com.msr.better.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-03-20
 */
@Service
public class HelloServiceImpl implements HelloService {

    private Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Autowired
    private OrderServiceApi orderServiceApi;


    @CacheResult
    @HystrixCommand(
            commandKey = "query",
            commandProperties = {
            @HystrixProperty(name="requestCache.enabled",value = "true")
    })
    @Override
    public String query(@CacheKey Integer id) {
        String test = orderServiceApi.test();
        log.info("result : {}", test);
        return test;
    }

    @CacheRemove(commandKey = "query")
    @HystrixCommand
    @Override
    public String update(@CacheKey Integer id) {
        log.info("update delete cache");
        return "update";
    }
}
