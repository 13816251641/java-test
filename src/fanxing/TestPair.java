package fanxing;



import java.util.Arrays;
import java.util.List;

/**
 * 测试泛型的上界和下界在出现T时候的使用,使用的测试实例是Pair类
 */
public class TestPair {
    public static void main(String[] args) {
        Pair<Integer> pair = new Pair<>(3);
        //xiaJie(pair,123);
        //shangJie(pair,321);
        func(Arrays.asList(1,2,3),123);

    }

    private static <T> void xiaJie(Pair<? super T> pair,T t) {
		/*
		 *
            pair.setFirst方法失效的原因是我们不知道T是什么类型的,
            除非入参传入T t 这样的类型才可以调用setFirst方法。
		 *
		 */
        pair.setFirst(t);
        Object object = pair.getFirst();//因为是super所以返回类型是Object
        System.out.println(object.getClass());
    }

    private static <T> void shangJie(Pair<? extends T> pair,T t) {
		/*
		 *
            pair.setFirst方法无效因为是extends,即使传入泛型的准确类型
            也是无效的:pair.setFirst(t);
		 *
		 */
        T first = pair.getFirst();//因为是extends所以返回类型是T
        System.out.println(first.getClass());
    }

    /**
     * 泛型T必须继承Number类,否则编译出错
     */
    private static <T extends Number> void func(List<T> list,T t){
         list.add(t);
    }


}

