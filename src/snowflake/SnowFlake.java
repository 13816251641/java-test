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
        System.out.println(timestamp);//1589361278195
        String result = Long.toBinaryString(timestamp);//十进制转为2进制
        System.out.println(result);//41位2进制
        System.out.println(2|1);//00000010 | 00000001 => 3
    }

    @Test
    public void show4(){
        //System.out.println(Long.toBinaryString(-1));11111111 负数在计算机中以补码的形式存在
        //System.out.println((-1)<<2);//-4
        //System.out.println(-1L ^ (-1L << 5));//2^5-1 这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数
        long sequence = 31;
        sequence = (sequence + 1) & 31;//n位二进制数所能表示的最大十进制数是否超标
        System.out.println(sequence);
    }


}
