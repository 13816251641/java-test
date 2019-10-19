package fanxing;

/**
 * 数组强转的问题
 * 数组也是一个对象,Object[] newArray = new Object[]{"AAA", "BBB"};
 * newArray对象是一个Ljava.lang.Object对象,和Ljava.lang.String对象
 * 没有任何父子类关系,所以强转失败;
 * Object[] newArray2 = new String[]{"AAA", "BBB"};
 * newArray2对象是一个Ljava.lang.String对象,所以能强转为Ljava.lang.String对象
 *
 */
public class ShuZuQiangZhuan {

    public static void main(String[] args) {

        Object[] newArray = new Object[]{"AAA", "BBB"};
        //java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
        String[] q = (String[]) (newArray);

        //ok
        Object[] newArray2 = new String[]{"AAA", "BBB"};
        System.out.println(newArray2.getClass().getName());
        String[] q2 = (String[]) (newArray);


    }

}
