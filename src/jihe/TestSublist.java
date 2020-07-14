package jihe;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.ArrayList的subList结果不可强转成ArrayList,否则会抛出ClassCastException异常,
 *   subList返回的是ArrayList的内部类SubList,并不是ArrayList
 * 2.在subList场景中,高度注意对原集合元素的的增加或删除,均会导致子列表的遍历、增加、
 *   删除均产生ConcurrentModificationException异常,但对subList的增加或删除不会报错,
 *   同时也会反映到原集合上去
 */
public class TestSublist {

    public static void main(String[] args) {
        List<String> parentList = new ArrayList<>();

        for(int i = 0; i < 5; i++){ // 0 1 2 3 4
            parentList.add(String.valueOf(i));
        }

        List<String> subList = parentList.subList(1, 3);//1 ,2
        for(String s : subList){
            System.out.println(s);//output: 1, 2
        }

        //non-structural modification by sublist, reflect parentList
        subList.set(0, "new 1");
        for(String s : parentList){
            System.out.println(s);//output: 0, new 1, 2, 3, 4
        }

        //structural modification by sublist, reflect parentList
        subList.add(String.valueOf(2.5));
        for(String s : parentList){
            System.out.println(s);//output:0,new 1,2,2.5,3,4
        }

        //non-structural modification by parentList, reflect sublist
        parentList.set(2, "new 2");
        for(String s : subList){
            System.out.println(s);//output: new 1, new 2
        }

        //structural modification by parentList, sublist becomes undefined(throw exception)
        parentList.add("undefine");
//        for(String s : subList){
//            System.out.println(s);
//        }
//        subList.get(0);

    }

    /**
     * ArrayList 的 subList 结果不可强转成 ArrayList，
     * 否则会抛出 ClassCastException 异 常：java.util.RandomAccessSubList cannot be cast to java.util.ArrayList。
     * subList 返回的是 ArrayList 的内部类 SubList，并不是 ArrayList 而是 ArrayList 的一个视图，对
     * 于 SubList 子列表的所有操作最终会反映到原列表上。
     */
    @Test
    public void testSublistToList(){
        List<String> parentList = new ArrayList<>();
        parentList.add("a");
        parentList.add("b");
        List<String> strings = parentList.subList(0, 1);
        System.out.println(strings);

    }



}
