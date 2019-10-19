package fanxing;


/**
 * 仍旧是泛型擦除的问题
 * (E[])new Object[10]泛型擦除后仍旧是Object[]
 * @param <E>
 */
public class MyArrayList<E> {

    private E[] elements;

    public MyArrayList(){
        elements=(E[])new Object[10];
    }

    public E[] getElements(){
        return elements;
    }



    public static void main(String[] args) {
        MyArrayList<String> m = new MyArrayList<>();
        String[] elements = m.getElements();

    }


}
