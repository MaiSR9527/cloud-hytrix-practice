package com.msr.better.order.controller;

import com.msr.better.order.api.GoodsApi;
import com.msr.better.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-03-20
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private GoodsApi goodsApi;

    @GetMapping("getOrder")
    public String getOrder(@RequestParam String name) {
        return orderService.getOrder(name);
    }

    @GetMapping("/goods/list")
    public String listGoods(@RequestParam String name) {
        return goodsApi.list(name);
    }

    @GetMapping("/goods/one")
    public String goodsOne() {
        return goodsApi.getOne();
    }

    @GetMapping("test")
    public String orderTest() {
        double random = Math.random();
//        if (random < 0.5) {
//            throw new RuntimeException();
//        } else {
//            return "order test success";
//        }
        return String.valueOf(random);
    }
}
