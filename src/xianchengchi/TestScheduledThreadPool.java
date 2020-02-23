package xianchengchi;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Auther ljn
 * @Date 2020/2/22
 * 每次都是直接new一个线程知道达到coreSize
 */
public class TestScheduledThreadPool {

    public static void main(String[] args) {
        delay();
       //rate();
    }

    /**
     * 延迟3秒后执行
     * schedule方法会延迟执行任务,虽然coreSize=3但还是一个一个往上+
     *
     * 这里只执行了一个任务,所以线程池的大小为1
     */
    public static void delay(){
        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        System.out.println("提交时间: " + sdf.format(new Date()));
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("运行时间: " + sdf.format(new Date()));
            }
        }, 3, TimeUnit.SECONDS);

        scheduledThreadPool.execute(()->{
            System.out.println("helo");
        });
    }

    /**
     * 定期重复执行
     */
    public static void rate(){
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        System.out.println("提交时间: " + df.format(new Date()));
        scheduledThreadPool.scheduleAtFixedRate(()->{
            System.out.println("运行时间:"+df.format(new Date()));
            int num=0;
            for(int i=0 ;i<=100000000;i++){
                num=i;
            }
        },1,3,TimeUnit.SECONDS);
    }
}
