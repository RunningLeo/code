package com.cyf.code.RateLimit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @desc: guava令牌桶限流
 * @Author: caoyafei
 * @Date: 2020/9/7 上午10:45
 */
public class RateLimiterTest {

    public static void RateTest() {

        //每秒钟产生2个令牌
        final RateLimiter rateLimiter = RateLimiter.create(2);

        for (int i = 0; i < 10; i++) {
            long timeOut =400;

            boolean isValid = rateLimiter.tryAcquire(timeOut, TimeUnit.MILLISECONDS);
            System.out.println("任务" + i + "执行是否有效:" + isValid);
            if (!isValid) {
                continue;
            }
            System.out.println("任务" + i + "在执行");
        }
        System.out.println("结束");
    }

    public static void main(String[] args) {

        RateTest();

    }

}


