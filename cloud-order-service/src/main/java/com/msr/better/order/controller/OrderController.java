package com.msr.better.order.controller;

import com.msr.better.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("getOrder")
    public String getOrder(@RequestParam String name) {
        return orderService.getOrder(name);
    }
}
