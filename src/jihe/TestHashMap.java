package jihe;

import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    /*
       String重写了equals和hashcode方法,所以可以使用String当做key来去重,
       这样效率会更高
     */
    @Test
    public void testOne(){
        Map<String,Integer> map = new HashMap<>();
        map.put("123",1);
        System.out.println(map.containsKey("123"));
    }


}
