package jihe;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TestHashMap {
    /*
       String重写了equals和hashcode方法,所以可以使用String当做key来去重,
       这样效率会更高
     */
    @Test
    public void testOne() {
        Map<String, Integer> map = new HashMap<>();
        map.put("123", 1);
        System.out.println(map.containsKey("123"));
    }


    /*
        alt+f8 可以在debugger的时候查看变量的值并进行修改!!!
     */
    @Test
    public void testTwo(){
        int a = 11;
        Map<String, Object> map = new HashMap<>();
        map.put("name","Pi");
        map.put("age",20);
        System.out.println(map);
    }
}
