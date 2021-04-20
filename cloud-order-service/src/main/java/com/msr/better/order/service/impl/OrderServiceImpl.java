package com.msr.better.order.service.impl;

import com.msr.better.order.service.IOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-03-20
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @HystrixCommand(fallbackMethod = "defaultFallBack")
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
