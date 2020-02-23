package xianchengchi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther ljn
 * @Date 2020/2/22
 * SingleThreadExecutor它的特点在于工作线程数目被限制为1，
 * 操作一个无界的工作队列，所以它保证了所有任务的都是被顺序执行，
 * 最多会有一个任务处于活动状态，并且不允许使用者改动线程池实例，
 * 因此可以避免其改变线程数目。
 *
 * 虽说它是single,却不是堵塞的
 *
 */
public class TestSingleThreadPool {

    public static void main(String[] args) throws Exception {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        for(int i=0;i<5;i++){
            int index=i;
            singleThreadExecutor.execute(()->{
                DateFormat df = new SimpleDateFormat("HH:mm:ss");
                System.out.println(index+"于"+df.format(new Date())+"开始运行");
                try {
                    Thread.sleep(2_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
