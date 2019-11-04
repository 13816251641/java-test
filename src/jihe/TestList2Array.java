package jihe;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试集合转数组的正确姿势
 * @Auther ljn
 * @Date 2019/11/4
 */
public class TestList2Array {

    /**
     * 不建议使用toArray(),返回的是Object数组
     * 不能直接对Object数组进行强转
     */
    @Test
    public void testOne(){
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(""+i);
        }
        Object[] objects = list.toArray();
        for (Object o: objects) {
            System.out.println(o.getClass().getName());
        }
    }

    /**
     * 建议使用
     */
    @Test
    public void testTwo(){
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(""+i);
        }
        String[] array =new String[list.size()];
        String[] strings = list.toArray(array);
        for (String s:strings){
            System.out.println(s);
        }
    }
}
