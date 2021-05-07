package com.msr.better.order.service.impl;

import com.msr.better.order.service.IOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-03-20
 */
@Service
public class OrderServiceImpl implements IOrderService {

    // 服务熔断：开启熔断-10秒内-10次请求-60%的请求失败-触发熔断
    @HystrixCommand(fallbackMethod = "defaultFallBack",
            commandProperties = {
            //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            //请求数达到后才计算
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //休眠时间窗
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            //错误率达到多少跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    @Override
    public String getOrder(String name) {
        if ("hystrix".equalsIgnoreCase(name)) {
            return "正确访问";
        } else {
            throw new RuntimeException("错误访问");
        }
    }

    public String defaultFallBack(String name) {
        return "this is defaultFallBack method!";
    }

}
