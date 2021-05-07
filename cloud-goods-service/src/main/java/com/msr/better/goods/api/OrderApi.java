package com.msr.better.goods.api;

import com.msr.better.goods.api.fallback.OrderApiFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-03-20
 */
@FeignClient(value = "cloud-order-service",fallback = OrderApiFallBack.class)
public interface OrderApi {

    @GetMapping("/order/test")
    public String orderTest();
}
