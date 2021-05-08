package com.msr.better.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-03-20
 */
@FeignClient(value = "cloud-order-service")
public interface OrderServiceApi {

    @GetMapping("/order/test")
    String test();
}
