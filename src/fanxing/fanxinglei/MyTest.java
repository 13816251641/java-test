package fanxing.fanxinglei;

import fanxing.fanxingshangxiajie.Pair;
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
        ContainerSon<String> containerSon = new ContainerSon("a");

        // ContainerSon<Integer> containerSon1 = new ContainerSon();报错,必须继承String
    }

    @Test
    public void test02(){
        ContainerSon<? super String> containerSon = new ContainerSon("a");// ? super String 只要这里的String满足extends String即可
        ContainerSon<? extends String> containerSon2 = new ContainerSon("b");// ? extends String 只要这里的String满足extends String即可
    }


    /**
     * @Description: 利用反射实例化泛型变量
     * @param
     * @return:
     * @Author: lujieni
     * @Date: 2021/2/17
     */
    @Test
    public void test03(){
        ContainerSon<String> containerSon = makeContainerSon(String.class);
        System.out.println(containerSon.getValue());
    }

    public static <T extends String> ContainerSon<T> makeContainerSon(Class<T> clazz){
        try {
            return new ContainerSon<>(clazz.newInstance());
        } catch (Exception e) {
            return null;
        }
    }

    @Test
    public void test04(){
        Container<Integer> container = new IntegerContainer(12);//ok

        // Container<String> errorContainer = new IntegerContainer(12);//ng Container<String>代表泛型一定要是String
    }



}