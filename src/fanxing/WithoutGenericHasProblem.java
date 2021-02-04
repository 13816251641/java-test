package fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个地方使用了泛型,别的地方也要使用,否则就是不安全的!!!
 */
public class WithoutGenericHasProblem {
   
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		unsafeAdd(strings,42);
		String s = strings.get(0);//java.lang.ClassCastException (runtime error)
	}

	/**
	 * List list =  new ArrayList<String>();没问题,但不安全
	 *
	 * @param list
	 * @param o
	 */
	private static void unsafeAdd(List list ,Object o) {
		System.out.println(o.getClass().getName());//java.lang.Integer
	    list.add(o);
	}
}
