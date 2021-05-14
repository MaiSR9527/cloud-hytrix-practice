package com.msr.better.service;

import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-03-20
 */
public interface HelloService {

    String query(@CacheKey Integer id);
    String update(@CacheKey Integer id);
}
