package idea;

import org.junit.Test;

/**
 * @Auther lujieni
 * @Date 2020/6/10
 */
public class TestDebug {

    @Test
    public void test(){
        method1();
        method3();
    }

    private void method1(){
        System.out.println("method1");
        method2();
    }

    private void method2(){
        System.out.println("method2");
    }

    private void method3(){
        System.out.println("method3");

    }

}
