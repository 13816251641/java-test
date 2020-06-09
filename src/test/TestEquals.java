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
}
