package fanxing.fanxinglei;

import org.junit.Test;

/**
 * @Package: fanxing.fanxinglei
 * @ClassName: MyTest
 * @Author: lujieni
 * @Description: 1
 * @Date: 2021-02-03 15:20
 * @Version: 1.0
 */
public class MyTest {

    @Test
    public void test01(){
        ContainerSon<Integer> containerSon = new ContainerSon();

        // ContainerSon<String> containerSon1 = new ContainerSon();报错,必须继承Number
    }

    @Test
    public void test02(){
        ContainerSon<? super Integer> containerSon = new ContainerSon();// ? super Integer 只要这里的Integer满足extends Number即可
    }



}