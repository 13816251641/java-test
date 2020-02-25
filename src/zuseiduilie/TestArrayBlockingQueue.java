package zuseiduilie;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Auther ljn
 * @Date 2020/2/23
 */
public class TestArrayBlockingQueue {

    public static void main(String[] args) throws Exception{
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3,false);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        new Thread(producer).start();
        new Thread(consumer).start();

    }
}

class Producer implements Runnable{

    private BlockingQueue<Integer> blockingQueue;

    private int element = 1;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (element <= 20){
            try {
                blockingQueue.put(element);//满了会阻塞
                System.out.println("放进去的元素是:"+element);
                ++element;
            }catch (InterruptedException e){
                System.out.println("生产者在等待空闲空间的时候被打断了!");
                e.printStackTrace();
            }
        }
        System.out.println("生产者已经终止了生产过程");
    }
}

class Consumer implements Runnable{
    private BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("取出来的元素是:"+blockingQueue.take());
            }catch (InterruptedException e){
                System.out.println("消费者在等待新产品的时候被打断了！");
                e.printStackTrace();
            }
        }
    }
}
