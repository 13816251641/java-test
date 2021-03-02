package duoxiancheng.mianshiti;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther ljn
 * @Date 2020/2/28
 * 基于Lock实现多线程的顺序执行
 * 当使用LOCK时可以不使用while因为condition可以唤醒指定的线程。
 * 同时注意必须先调用 conditionA.signal(); 再调用 lock.unlock();
 * 否则会抛 java.lang.IllegalMonitorStateException 异常。
 * 因为在调用unlock之后，当前线程已不是此监视器对象condition的持有者。
 * 也就是说要在此线程持有锁定对象时，才能使用此锁定对象。
 */
public class MyService2 {
    private ReentrantLock lock = new ReentrantLock();
    private Condition conditionB = lock.newCondition();//每个Condition都是不一样的
    private Condition conditionC = lock.newCondition();
    private int flag = 1;

    private void taskA(){
        lock.lock();
        try{
            flag = 2;
            System.out.println("taskA");
            conditionB.signal();//调用signal()方法后一定要释放当前占用的锁（代码29行）
        }finally {
           lock.unlock();
        }
    }

    private void taskB(){
       lock.lock();
       try {
           if(flag !=2) {
               try {
                   conditionB.await();//线程等待并释放锁
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
           flag = 3;
           System.out.println("taskB");//调用signal()方法后一定要释放当前占用的锁（代码44行）
           conditionC.signal();
       }finally {
           lock.unlock();
       }
    }

    private void taskC(){
        lock.lock();
        try {
            if(flag != 3){
                try {
                    conditionC.await();//线程等待并释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("taskC");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        MyService2 service = new MyService2();
        new Thread(()->{
            service.taskC();
        }).start();
        Thread.sleep(50);
        new Thread(()->{
            service.taskB();
        }).start();
        Thread.sleep(50);
        new Thread(()->{
            service.taskA();
        }).start();
    }

}
