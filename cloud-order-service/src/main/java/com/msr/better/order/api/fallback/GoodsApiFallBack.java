package com.msr.better.order.api.fallback;

import com.msr.better.order.api.GoodsApi;
import org.springframework.stereotype.Component;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-03-20
 */
@Component
public class GoodsApiFallBack implements GoodsApi {
    @Override
    public String list(String name) {
        return "请求order->list失败！";
    }

    @Override
    public String getOne() {
        return "请求order->getOne失败！";
    }
}
