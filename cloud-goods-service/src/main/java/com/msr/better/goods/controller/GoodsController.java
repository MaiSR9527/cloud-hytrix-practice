package com.msr.better.goods.controller;

import com.msr.better.goods.api.OrderApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-03-20
 */
@RestController
@RequestMapping("goods")
public class GoodsController {
    private Logger log = LoggerFactory.getLogger(GoodsController.class);


    @Autowired
    private OrderApi orderApi;

    @GetMapping(value = "/list")
    public String list(@RequestParam String name) throws Exception {
        if (name.equals("phone")) {
            double random = Math.random();
            log.info("随机数:{}", random);
            if (random <= 0.5) {
                TimeUnit.SECONDS.sleep(60);
            }
            return "This is real request";
        } else {
            throw new Exception();
        }
    }

    @GetMapping(value = "/one")
    public String getOne() throws Exception {
//        TimeUnit.SECONDS.sleep(60);
        return "success";
    }

    @GetMapping("order/test")
    public Object orderTest(){
        return orderApi.orderTest();
    }
}
