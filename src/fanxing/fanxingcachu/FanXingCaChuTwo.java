package fanxing.fanxingcachu;


/**
 * 仍旧是泛型擦除的问题
 * (E[])new Object[10]泛型擦除后仍旧是Object[]
 *
 */
public class FanXingCaChuTwo<E> {

    private E[] elements;

    public FanXingCaChuTwo(){
        elements=(E[])new Object[10];
    }

    public E[] getElements(){
        return elements;
    }


    public static void main(String[] args) {
        FanXingCaChuTwo<String> m = new FanXingCaChuTwo<>();
        /* [Ljava.lang.Object; cannot be cast to [Ljava.lang.String */
        String[] elements = m.getElements();

    }


}
