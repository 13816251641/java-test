package fanxing.shuzu;

import java.lang.reflect.Array;

/**
 * @Auther ljn
 * @Date 2019/12/19
 * 利用反射生成泛型数组
 */
public class GenerateFanXingShuZu {

    public static void main(String[] args) {
        String a = "ccc";//创建一个String，作为泛型类型
        String[] arr = createArray(a);
        for(String art :arr)//循环打印
            System.out.println(art);

    }

    private static <T> T[] createArray(T t){
        /* Class<?> clazz = t.getClass(); */
        T[] arr = (T[])Array.newInstance(t.getClass(), 5);
        System.out.println(arr.getClass().getName());
        arr[0] = t;
        return  arr;
    }



}
