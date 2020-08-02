package cn.com.spider;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName RateLimiterUtils
 * @Description guava 限流使用
 * @Author spiderMao
 * @Date 2020/5/27 09:17
 * @Version V1.0
 **/
public class RateLimiterUtils {

    /**
     * @Author spiderMao
     * @Description 来以阻塞的方式获取令牌
     * @Date 10:50 2020/5/27
     * @Param []
     * @return void
     **/
    public static void rateLimiter1() {
        //每秒创建一个令牌
        RateLimiter limiter = RateLimiter.create(1);
        for (int i = 1; i < 10; i = i + 2) {
            //获取i个令牌
            double waitTime = limiter.acquire(i);
            System.out.println("cutTime=" + System.currentTimeMillis() + " acq:" + i + " waitTime:" + waitTime);
        }
    }

    public static void rateLimiter2() {
        //每秒创建一个令牌
        RateLimiter limiter = RateLimiter.create(1);
        for (int i = 1; i < 20; i ++) {
            //获取i个令牌
            double waitTime = limiter.acquire(i);
            System.out.println("cutTime=" + System.currentTimeMillis() + " acq:" + i + " waitTime:" + waitTime);
        }
    }

    public static void rateLimiter3() {
        //每秒创建一个平滑预热限流
        RateLimiter limiter = RateLimiter.create(2, 3, TimeUnit.SECONDS);
        for (int i = 1; i < 20; i ++) {
            //获取i个令牌
            double waitTime = limiter.acquire(3);
            System.out.println("cutTime=" + System.currentTimeMillis() + " acq:" + i + " waitTime:" + waitTime);
        }
    }
}
