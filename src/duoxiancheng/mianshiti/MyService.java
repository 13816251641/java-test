package duoxiancheng.mianshiti;

/**
 * @Auther ljn
 * @Date 2020/2/19
 * 实现3个线程同时启动,只有A线程执行完才会执行B线程,B线程执行完再去执行C线程
 *
 * 线程在调用wait、notify、notifyAll的时候必须获得该对象的对象级别锁,想要获取
 * 该对象的对象级别锁，也就只有在同步方法或同步代码块中
 */
public class MyService {

    private int flag = 1;

    public synchronized void taskA(){
        while (flag != 1){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("doing taskA");
        flag=2;
        this.notifyAll();
    }

    public synchronized void taskB(){
        while (flag != 2){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("doing taskB");
        flag=3;
        this.notifyAll();
    }

    public synchronized void taskC(){
        while (flag != 3){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("doing taskC");
    }

    public static void main(String[] args) {
        MyService myService = new MyService();
        new Thread(()->{
            myService.taskC();
        },"t3").start();
        new Thread(()->{
            myService.taskB();
        },"t2").start();
        new Thread(()->{
            myService.taskA();
        },"t1").start();
    }
}
