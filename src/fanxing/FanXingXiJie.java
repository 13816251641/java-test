package fanxing;

import java.util.Arrays;
import java.util.List;

/**
 * Class<?> cs 得到的是object类型的
 */
public class FanXingXiJie {

    public static void main(String[] args) {

        String s = "a";

        String show = show(s);

        String s1 = createElement(String.class);

        getElement(Arrays.asList("a", "b"));


    }

    private static <T> T createElement(Class<T> c) {
        try {
            return c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            return null;
        }
    }


    public static <T> T show(T t) {
        Class<?> cs = t.getClass();//Class<?>里面元素为object
        Object o = createElement(cs);//因为Class<?>中的元素为object
        return null;
    }

    /**
       如果使用List<?> list来接收参数的话,
       从list中取的数据类型为Object
     */
    private static void getElement(List<?> list) {
        Object o = list.get(0);
    }
}
