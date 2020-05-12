package string;

import org.junit.Test;

/**
 * @Auther lujieni
 * @Date 2020/4/10
 */
public class TestString {

    @Test
    public void test(){
        String a = String.format("%s---%s", "a", null);
        System.out.println(a);
    }

    @Test
    public void test2(){
        boolean contains = "510000-510400-510403".contains("510000-510400-");
        System.out.println(contains);
    }

    @Test
    public void test3(){
        String n=null;
        String result = "122222-222221-null".replace("null", "");
        System.out.println(""+n);
    }
}
