package xianliu;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Package: xianliu
 * @ClassName: UseRateLimiter
 * @Author: lujieni
 * @Description: 使用RateLimiter
 * @Date: 2021-03-08 17:11
 * @Version: 1.0
 *
 */
public class UseRateLimiter {

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final int THREAD_COUNT = 25;


    @Test
    public void testRateLimiter1() {
        RateLimiter rateLimiter = RateLimiter.create(1);//200ms放一个令牌

        Thread[] ts = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            ts[i] = new Thread(new RateLimiterThread(rateLimiter), "RateLimiterThread-" + i);
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            ts[i].start();
        }

        while (true){

        }
    }

    public class RateLimiterThread implements Runnable {

        private RateLimiter rateLimiter;

        public RateLimiterThread(RateLimiter rateLimiter) {
            this.rateLimiter = rateLimiter;
        }

        @Override
        public void run() {
            rateLimiter.acquire(1);

            System.out.println(Thread.currentThread().getName() + "获取到了令牌，时间 = " + FORMATTER.format(new Date()));
        }

    }


    @Test
    public void testRateLimiter2() {

        RateLimiter rateLimiter = RateLimiter.create(1);//1秒放1个令牌

        System.out.println("获取1个令牌开始，时间为" + FORMATTER.format(new Date()));
        double cost = rateLimiter.acquire(1);
        System.out.println("获取1个令牌结束，时间为" + FORMATTER.format(new Date()) + ", 耗时" + cost + "ms");
        System.out.println("获取5个令牌开始，时间为" + FORMATTER.format(new Date()));
        cost = rateLimiter.acquire(5);
        System.out.println("获取5个令牌结束，时间为" + FORMATTER.format(new Date()) + ", 耗时" + cost + "ms");
        System.out.println("获取3个令牌开始，时间为" + FORMATTER.format(new Date()));
        cost = rateLimiter.acquire(3);
        System.out.println("获取3个令牌结束，时间为" + FORMATTER.format(new Date()) + ", 耗时" + cost + "ms");
    }


}