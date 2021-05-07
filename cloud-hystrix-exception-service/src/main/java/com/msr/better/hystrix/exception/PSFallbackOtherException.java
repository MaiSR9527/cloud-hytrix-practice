package com.msr.better.hystrix.exception;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-03-20
 */
public class PSFallbackOtherException extends HystrixCommand<String> {

    public PSFallbackOtherException() {
        super(HystrixCommandGroupKey.Factory.asKey("GroupOE"));
    }

    @Override
    protected String run() throws Exception {
        throw new Exception("this command will trigger fallback");
    }

    @Override
    protected String getFallback() {
        System.out.println(super.getFailedExecutionException().getMessage());
        return "invoke PSFallbackOtherExpcetion fallback method";
    }
}
