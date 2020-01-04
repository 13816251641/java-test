package jihe;

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



}
