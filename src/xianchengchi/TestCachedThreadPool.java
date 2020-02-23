package xianchengchi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther ljn
 * @Date 2020/2/22
 * 有闲置的工作线程就复用,没有就创建。对于线程池的最大线程
 * 数没有限制。如果线程闲置的时间超过60秒,则被终止并移出缓存。
 */
public class TestCachedThreadPool {

    public static void main(String[] args) throws Exception {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        //当新的任务来的时候首先确认是否存在空闲的线程,有就复用没有就创建
        cachedThreadPool.execute(()->{
            System.out.println("hello");
        });

        Thread.sleep(2_000);

        cachedThreadPool.execute(()->{
            System.out.println("hello");
        });

/*        for(int i=0;i<5;i++){
            int index=i;
            cachedThreadPool.execute(()->{
                DateFormat df = new SimpleDateFormat("HH:mm:ss");
                System.out.println(index+"于"+df.format(new Date())+"开始运行");
                try {
                    Thread.sleep(2_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }*/
    }
}
