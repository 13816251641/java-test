package fanxing;

import fanxing.fanxingshangxiajie.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 泛型细节
 * 从Class<?> cs 得到的是object类型的
 */
public class FanXingXiJie {

    /**
     * 测试利用Class<?>生成实体类,发现类型只是Object
     * @throws Exception
     */
    @Test
    public void testOne() throws Exception{
        String s = "abc";
        String string = show(s);
    }

    private <T> T show(T t) throws Exception{
        Class<?> cs = t.getClass();
        /* 猜想因为cs中的元素为Object,所以createElement返回Object
         * 但运行时类型还是对的
         */
        Object o = createElement(cs);
        return (T)o;
    }



    /**
     * 测试利用字节码文件生成实体类
     * @throws Exception
     */
    @Test
    public void testTwo() throws Exception{
        String s = createElement(String.class);
    }

    /**
     *如果使用List<?>来接收参数的话,从List<?>中取的数据类型为Object
     */
    @Test
    public void testThree(){
        getElement(Arrays.asList("a", "b"));
    }

    /**
     * List<Pair<?>>list的入参一定要是List<Pair<?>>,不能是List<Pair>或者List<Pair<String>>
     */
    @Test
    public void testFour(){
        List<Pair<?>> list = new ArrayList<>();
        innerGeneric(list);
    }

    /**
     * 注意这里的入参是List<Pair<?>> list
     */
    public void innerGeneric(List<Pair<?>> list){

    }

    /**
     *取出的数据类型编译时为Object,运行时类型可以强转为实际类型
     */
    private void getElement(List<?> list) {
        Object o = list.get(0);
        System.out.println(o.getClass().getName());
    }


    private <T> T createElement(Class<T> clazz) throws Exception {
        return clazz.newInstance();
    }


}
