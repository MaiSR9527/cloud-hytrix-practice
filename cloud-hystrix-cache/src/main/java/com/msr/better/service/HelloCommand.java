package com.msr.better.service;

import com.msr.better.api.OrderServiceApi;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-03-20
 */
public class HelloCommand extends HystrixCommand<String> {

    private static Logger log = LoggerFactory.getLogger(HelloCommand.class);

    private OrderServiceApi orderServiceApi;
    private String key;

    public HelloCommand(OrderServiceApi orderServiceApi, String key) {
        super(HystrixCommandGroupKey.Factory.asKey("springCloudCacheGroup"));
        this.orderServiceApi = orderServiceApi;
        this.key = key;
    }

    public static void cleanCache(Long key) {
        HystrixRequestCache.getInstance(
                HystrixCommandKey.Factory.asKey("springCloudCacheGroup"),
                HystrixConcurrencyStrategyDefault.getInstance()).clear(String.valueOf(key));
    }

    @Override
    protected String run() throws Exception {
        String test = orderServiceApi.test();
        log.info("command结果:{}", test);
        return test;
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(key);
    }
}
