package com.msr.better.threadcontext.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-05-14 22:52
 **/
@Configuration
public class HystrixThreadContextConfiguration {
    @Bean
    public SpringCloudHystrixConcurrencyStrategy springCloudHystrixConcurrencyStrategy() {
        return new SpringCloudHystrixConcurrencyStrategy();
    }
}
