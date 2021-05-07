package com.msr.better.goods.api.fallback;

import com.msr.better.goods.api.OrderApi;
import org.springframework.stereotype.Component;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-03-20
 */
@Component
public class OrderApiFallBack implements OrderApi {
    @Override
    public String orderTest() {
        return "请求cloud-order-service失败！";
    }
}
