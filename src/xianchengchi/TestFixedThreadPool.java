package xianchengchi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther ljn
 * @Date 2020/2/22
 * 线程池的大小一旦达到最大值后，再有新的任务提交时则放入无界阻塞队列中，
 * 等到有线程空闲时，再从队列中取出任务继续执行。
 * 如果有工作线程退出，将会有新的工作线程被创建，以补足指定的数目nThreads。
 * 为啥会有工作线程退出呢,简单:线程执行代码报错了不就退出了吗
 */
public class TestFixedThreadPool {

    public static void main(String[] args) throws Exception {
        ExecutorService fixedThreadPool  = Executors.newFixedThreadPool(3);

     /*
        有新的任务来的时候永远只会新建一个线程直到达到上限
        fixedThreadPool.execute(()->{
            System.out.println("hello");
        });

        Thread.sleep(2_000);

        fixedThreadPool.execute(()->{
            System.out.println("hello");
        });
      */

        for(int i=0;i<5;i++){
            int index = i;
            fixedThreadPool.execute(()->{
                DateFormat df = new SimpleDateFormat("HH:mm:ss");
                System.out.println(index+"于"+df.format(new Date())+"开始运行");
                try {
                    Thread.sleep(2_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


       // fixedThreadPool.shutdown();//如果不调用shutdown,jvm不会退出因为有用户线程
    }




}
