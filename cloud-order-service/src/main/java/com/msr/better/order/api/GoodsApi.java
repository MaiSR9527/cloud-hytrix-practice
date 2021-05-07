package com.msr.better.order.api;

import com.msr.better.order.api.fallback.GoodsApiFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-03-20
 */
@Component("goodsApi")
@FeignClient(value = "cloud-goods-service",fallback = GoodsApiFallBack.class)
public interface GoodsApi {
    @GetMapping("/order/list")
    String list(@RequestParam String name);

    @GetMapping("/order/one")
    String getOne();
}
