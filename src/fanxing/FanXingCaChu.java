package fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型擦除示例
 */
public class FanXingCaChu {
	public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("m");
		String[] show = show(list);
		System.out.println(show);
	}

	private  static <T> T[] show(List<T> list) {
		/*
		   因为泛型擦除,T[]在运行时变为Object[] t
		 */
		T[] t = (T[]) list.toArray();
        System.out.println(t.getClass().getName());
		return t;
	}

}
