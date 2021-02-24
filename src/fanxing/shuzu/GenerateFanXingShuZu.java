package fanxing.shuzu;

import org.junit.Test;

import java.lang.reflect.Array;

/**
 * @Auther ljn
 * @Date 2019/12/19
 * 利用反射生成泛型数组
 */
public class GenerateFanXingShuZu {

    public static void main(String[] args) throws Exception {
        /*String a = "ccc";//创建一个String，作为泛型类型
        String[] arr = createArray(a);
        for(String art :arr)//循环打印
            System.out.println(art);*/
        String[] as = huhu("a");
        System.out.println(as.length);
    }

    private static <T> T[] huhu(T t) throws IllegalAccessException, InstantiationException {
        T[] o = (T[])Array.newInstance(t.getClass(), 5);
        return o;
    }

    private static <T> T[] createArray(T t){
        /* Class<?> clazz = t.getClass(); */
        T[] arr = (T[])Array.newInstance(t.getClass(), 5);
        System.out.println(arr.getClass().getName());
        arr[0] = t;
        return  arr;
    }

    @Test
    public void test01(){
        MyArrayList<String> list = new MyArrayList();
        list.set(0,"a");
        String result = list.get(0);
        System.out.println(result);
    }
}

class MyArrayList<E>{
    private Object[] elements;

    public MyArrayList(){
        elements = new Object[10];
    }

    public E get(int n){
        E element = (E) elements[n];//泛型擦除后为Object
        System.out.println(element.getClass().getName());//java.lang.String
        return element;
    }

    public void set(int n,E e){
        elements[n] = e;
    }
}
