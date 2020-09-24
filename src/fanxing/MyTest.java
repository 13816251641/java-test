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
        List<String> abc = list;//非泛型变量可以赋值给泛型变量,但有风险
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


}
