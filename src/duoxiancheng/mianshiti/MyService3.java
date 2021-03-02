package duoxiancheng.mianshiti;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

/**
 * @Package: duoxiancheng.mianshiti
 * @ClassName: MyService3
 * @Author: lujieni
 * @Description: 1
 * @Date: 2021-03-02 11:19
 * @Version: 1.0
 */
public class MyService3 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Handler handler = new Handler(lock);
        Stream.of("P1","P2").forEach(n->
                new Thread(() -> {
                    while (true) {
                        handler.produce();
                    }
                }).start());

        Stream.of("C1","C2").forEach(n->
                new Thread(() -> {
                    while (true) {
                        handler.consume();
                    }
                }).start());

    }



}

class Handler{
    private int num;
    private Lock lock;
    private boolean flag = true;//true:可以生产 false:可以消费
    private Condition produceCondition;
    private Condition consumeCondition;


    public Handler(Lock lock){
        this.lock = lock;
        this.produceCondition = lock.newCondition();
        this.consumeCondition = lock.newCondition();
    }

    public void produce(){
        lock.lock();
        try {
            if(flag){
                num++;
                System.out.println(Thread.currentThread().getName()+"-produce:"+num);
                flag = !flag;
                consumeCondition.signal();
            }else{
                produceCondition.await();//释放锁并等待
            }
        }catch (Exception e){
            lock.unlock();
        }
    }

    public void consume(){
        lock.lock();
        try{
            if(flag){
                consumeCondition.await();//释放锁并等待
            }else{
                //可以消费
                System.out.println(Thread.currentThread().getName()+"-consume:"+num);
                flag = !flag;
                produceCondition.signal();
            }

        }catch (Exception e){

        }

    }


}

