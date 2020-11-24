package shiyongapi;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther lujieni
 * @Date 2020-11-24 10:40
 */
public class UseSplit {

    /**
     * 用"|"进行分割字符串必须使用"\\|的写法"
     */
    @Test
    public void test01(){
        String[] result = "2|33|4".split("\\|");
        System.out.println(Arrays.toString(result));
    }


    /**
     * 用"."进行分割字符串必须使用"\\.的写法"
     */
    @Test
    public void test02(){
        String[] result = "172.0.0.1".split("\\.");
        System.out.println(Arrays.toString(result));
    }

    /**
     * 用","进行分割字符串使用,即可
     */
    @Test
    public void test03(){
        String[] result = "172,0,0,1".split(",");
        System.out.println(Arrays.toString(result));
    }


}