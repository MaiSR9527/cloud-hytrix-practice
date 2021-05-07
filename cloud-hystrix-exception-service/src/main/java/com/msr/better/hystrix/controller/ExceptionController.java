package com.msr.better.hystrix.controller;

import com.msr.better.hystrix.exception.PSFallbackBadRequestException;
import com.msr.better.hystrix.exception.PSFallbackOtherException;
import com.msr.better.hystrix.exception.ProviderServiceCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-03-20
 */
@RestController
public class ExceptionController {
    private static Logger log = LoggerFactory.getLogger(ExceptionController.class);

    @GetMapping("/getProviderServiceCommand")
    public String providerServiceCommand(){
        String result = new ProviderServiceCommand("World").execute();
        return result;
    }


    @GetMapping("/getPSFallbackBadRequestException")
    public String providerServiceFallback(){
        String result = new PSFallbackBadRequestException().execute();
        return result;
    }


    @GetMapping("/getPSFallbackOtherException")
    public String pSFallbackOtherException(){
        String result = new PSFallbackOtherException().execute();
        return result;
    }

    @GetMapping("/getFallbackMethodTest")
    @HystrixCommand(fallbackMethod = "fallback")
    public String getFallbackMethodTest(String id){
        throw new RuntimeException("getFallbackMethodTest failed");
    }

    public String fallback(String id, Throwable throwable) {
        log.error(throwable.getMessage());
        return "this is fallback message";
    }

}

