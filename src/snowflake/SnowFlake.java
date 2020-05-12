package snowflake;

import org.junit.Test;

/**
 * @Auther lujieni
 * @Date 2020/5/12
 */
public class SnowFlake {


    /**
     * 数学意义：在数字没有溢出的前提下，对于正数和负数，
     * 左移一位都相当于乘以2的1次方，左移n位就相当于乘以2的n次方。
     */
    @Test
    public void show(){
        System.out.println(5<<2);//20
    }

    /**
     * 0101
     * 0010
     *
     * 0111
     */
    @Test
    public void show2(){
        System.out.println(5|2);//7
    }

    @Test
    public void show3(){
        Long timestamp  = System.currentTimeMillis();
        System.out.println(timestamp);
        String result = Long.toBinaryString(timestamp);//1100
        System.out.println(result.length());
    }


}
