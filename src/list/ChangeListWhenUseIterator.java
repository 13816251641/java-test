package list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @Auther ljn
 * @Date 2019/12/24
 * 测试使用Iterator的时候修改list
 */
public class ChangeListWhenUseIterator {

    @Test
    public void test1(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(Integer.valueOf(i));
        }

        ListIterator<Integer> iterator = arrayList.listIterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer.intValue() == 5) {
                iterator.set(Integer.valueOf(6));
                iterator.remove();
                iterator.add(integer);
            }
        }

    }

}
