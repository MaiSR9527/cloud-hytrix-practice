package com.msr.better.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-03-20
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
