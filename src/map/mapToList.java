package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther ljn
 * @Date 2019/12/20
 * 将map的key和value分别转化为list
 */
public class mapToList {
    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        map.put("4", "D");
        map.put("5", "E");
        /* map.keySet()返回的是Set */
        List<String> keylist =new ArrayList<>(map.keySet());
        for(String key:keylist ){
            System.out.println(key);
        }
        /* map.values()返回的是collection，通过arrayList的构造方法可以实现 */
        List<String> valuesList = new ArrayList<String>(map.values());
        for(String str:valuesList){
            System.out.println(str);
        }


    }
}
