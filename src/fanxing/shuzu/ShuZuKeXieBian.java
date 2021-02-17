package fanxing.shuzu;

/**
 * 数组是可协变的,会记住它创建的时候存的类型
 */
public class ShuZuKeXieBian {
	public static void main(String[] args) {
        
		Object[] arr1 = new String[6];
		arr1[0] = "array";
	    System.out.println(arr1.getClass().getName()); 	   //[Ljava.lang.String;
		System.out.println(arr1[0].getClass().getName());     //java.lang.String

		
		Object[] arr2 = new Object[6];
		arr2[0] = "string";
		System.out.println(arr2.getClass().getName());   //[Ljava.lang.Object
		System.out.println(arr2[0].getClass().getName());//java.lang.String

		
 	}
}
