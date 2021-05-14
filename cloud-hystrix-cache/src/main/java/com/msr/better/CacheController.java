package com.msr.better;

import com.msr.better.api.OrderServiceApi;
import com.msr.better.service.HelloCommand;
import com.msr.better.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-03-20
 */
@RestController
public class CacheController {

    private static Logger log = LoggerFactory.getLogger(CacheController.class);

    @Autowired
    private OrderServiceApi orderServiceApi;

    @Autowired
    private HelloService helloService;

    @GetMapping("/getCacheByClassExtendCommand")
    public String testCache() {
        HelloCommand command1 = new HelloCommand(orderServiceApi, "testCache");
        String res = command1.execute();
        log.info("controller from cache:{}", res);
        HelloCommand command2 = new HelloCommand(orderServiceApi, "testCache");
        String res2 = command2.execute();
        log.info("controller from cache:{}", res2);
        return "the second execute result is from cache " + command2.isResponseFromCache();
    }


    /**
     * 基于注解的缓存，id为缓存的key
     *
     * @param id
     * @return
     */
    @GetMapping("/query/{id}")
    public String query(@PathVariable("id") Integer id) {
        String query1 = helloService.query(id);
        String query2 = helloService.query(id);
        String query3 = helloService.query(1000);
        String query4 = helloService.query(1000);
        return query1 + "  " + query2 + "   " + query3 + "   " + query4;
    }


    /**
     * 更新删除缓存
     *
     * @param id
     * @return
     */
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id) {
        // 两次调用，第二次直接查缓存
        helloService.query(id);
        helloService.query(id);
        // 移除缓存
        helloService.update(id);
        // 再两次调用，重新创建缓存
        helloService.query(id);
        helloService.query(id);

        return "success";
    }
}
