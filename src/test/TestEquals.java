package test;

import org.junit.Test;

import java.util.Objects;

/**
 * @Auther lujieni
 * @Date 2020/6/4
 */
public class TestEquals {
    @Test
    public void test(){
        Integer a = null;
        boolean result = Objects.equals(0, a);
        System.out.println(result);
    }


    /**
     * @Description: Long类型和Integer类型比较
     * @param
     * @return:
     * @Author: lujieni
     * @Date: 2020/12/17
     */
    @Test
    public void test2(){
        Integer a = new Integer(-1);
        boolean result = Objects.equals(-1L, a);//Integer和Long类型比较即使值相同也是false
        System.out.println(result);
    }

    /**
     * @Description: 负数也支持比较
     * @param
     * @return:
     * @Author: lujieni
     * @Date: 2020/12/17
     */
    @Test
    public void test3(){
        Integer a = new Integer(-1);
        boolean result = Objects.equals(-1, a);//true
        System.out.println(result);
    }
}
