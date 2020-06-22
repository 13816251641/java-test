package mianshi;

/**
 * @Auther lujieni
 * @Date 2020/6/22
 */
public class TestThreadInOrder {

    private int count = 3;

    public static void main(String[] args) {
        TestThreadInOrder service = new TestThreadInOrder();
        new Thread(()->{
            service.showA();
        }).start();
        new Thread(()->{
            service.showB();
        }).start();
        new Thread(()->{
            service.showC();
        }).start();
    }

    public synchronized void showA(){
        while (count != 1){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("showA");
    }

    public synchronized void showB(){
        while (count != 2){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("showB");
        count = 1;
        this.notifyAll();

    }

    public synchronized void showC(){
        while (count != 3){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("showC");
        count = 2;
        this.notifyAll();
    }

}








