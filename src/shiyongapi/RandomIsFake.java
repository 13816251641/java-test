package shiyongapi;

import java.util.Random;

/**
 * @Auther ljn
 * @Date 2019/12/25
 * Random是伪随机
 */
public class RandomIsFake {

    public static void main(String[] args) {
        Random random=new Random(1l);
        Random random1=new Random(1l);
        System.out.println(random.nextInt());
        System.out.println(random1.nextInt());

        System.out.println(random.nextDouble());
        System.out.println(random1.nextDouble());

    }


}
