package fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型擦除示例
 *
 * 运行时类型擦除会将T->Object,T[]->Object[],在泛型方法外部虚拟机
 * 会自动帮你加上对应的强转,示例可参考(String[])show(list)
 *
 */
public class FanXingCaChu {
	public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("m");
        /*
         *	Ljava.lang.Object; cannot be cast to Ljava.lang.String
         *  经过反编译:(String[])show(list);这里强转异常是因为
         *  list.toArray()方法的返回值类型Ljava.lang.Object的编译时
         *  类型为Ljava.lang.Object,而运行时类型也是Ljava.lang.Object
         */
		String[] show = show(list);
		System.out.println(show);
	}

	private  static <T> T[] show(List<T> list) {
		T t1 = list.get(0);
		/*
		    没问题,t1的类型是String
		 */
		System.out.println(t1.getClass().getName());

		/*
		   list.toArray()返回的类型是Object[],在代码
		   运行的时候下面语句竟然不报错,说明了因为泛型
		   擦除机制让(T[])的强转变为了Object[],Object[]类型
		   强转为Object[]类型当然是可以的
		 */
		T[] t = (T[]) list.toArray();
		/*
		   Ljava.lang.Object类型
		 */
        System.out.println(t.getClass().getName());
		return t;
	}

}
