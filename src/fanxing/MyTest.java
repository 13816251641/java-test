package fanxing;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther ljn
 * @Date 2020/2/13
 */
public class MyTest {

    @Test
    public void test01(){
        List list = new ArrayList();
        list.add("a");
        list.add(1);
        List<String> abc = list;//非泛型bean可以赋值给泛型bean,但有风险
        show(list);
    }

    /**
     * List<String> list可以接受非泛型对象,但我们用的时候就要小心了
     * @param list
     */
    private void show(List<String> list){
        String s1 = list.get(0);
        System.out.println(s1);
        String s2 = list.get(1);
        System.out.println(s2);
    }



    public static void swap(Pair<?> p) { swapHelper(p); }


    public static <T> void swapHelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }


    public static void main(String[] args) {
      /*  Pair<String> pair = new Pair<>("a","b");
        swap(pair);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());*/

        Pair<Integer> result = new Pair<>(1,2);
        maxminBonus(result);

    }



    public static void maxminBonus(Pair<? extends Number> result) {
        hello(result);
    }

    private static <T> void hello(Pair<T> pair){
        T first = pair.getFirst();
        System.out.println(first.getClass().getName());
        pair.setFirst(pair.getSecond());
    }






}

class Pair<T>{
    private T first;
    private T second;

    public Pair(T first,T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
