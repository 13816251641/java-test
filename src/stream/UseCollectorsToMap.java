package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UseCollectorsToMap {

    /**
     *
     * 测试使用stream 的 toMap 方法将list->map
     *
     * 1.在使用 java.util.stream.Collectors 类的 toMap()方法转为 Map 集合时，一定要使
     * 用含有参数类型为 BinaryOperator，参数名为 mergeFunction 的方法，否则当出现相同 key
     * 值时会抛出 IllegalStateException 异常
     * 说明：参数 mergeFunction 的作用是当出现 key 重复时，自定义对 value 的处理策略。
     *
     * 2.在使用 java.util.stream.Collectors 类的 toMap()方法转为 Map 集合时，一定要注
     * 意当 value 为 null 时会抛 NPE 异常。
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
        //pairArrayList.add(new Pair<>("version", null)); value为空时会抛异常
        pairArrayList.add(new Pair<>("version1", 10.14));
        pairArrayList.add(new Pair<>("version1", 10.24));
        pairArrayList.add(new Pair<>("version1", 10.34));
        pairArrayList.add(new Pair<>("version2", 15.38));
        Map<String, Double> result = pairArrayList.stream().collect(Collectors.toMap(e -> {
            return e.getKey();
        }, e -> {
            return e.getValue();
        },(oldData,newData)->{
            return newData; //key冲突的时候 value该咋办
        }));

       /* Map<String, Double> result = pairArrayList.stream().collect(Collectors.toMap(e -> {
            return e.getKey();
        }, e -> {
            return e.getValue();
        }));*/


        System.out.println(result);
    }
}

class Pair<K,V>{

    private K key;
    private V value;

    public Pair(K k,V v){
        this.key = k;
        this.value = v;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}