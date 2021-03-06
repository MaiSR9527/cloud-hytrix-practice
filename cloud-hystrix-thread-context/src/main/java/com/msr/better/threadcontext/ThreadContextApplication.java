package com.msr.better.threadcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-05-14 22:46
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class ThreadContextApplication {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ThreadContextApplication.class, args);
    }
}
