package map;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther ljn
 * @Date 2020/1/7
 * map的深拷贝、浅拷贝
 */
public class UseDeepCopy {

    private HashMap<String, Object> map;
    private List<Integer> list;

    @Before
    public void init(){
        map = new HashMap<String, Object>();
        list = new ArrayList<Integer>();
        list.add(100);
        list.add(200);
        map.put("basicType", 100);
        map.put("list", list);
    }

    @Test
    public void test1(){
        // 数据展示
        System.out.println("------数据展示--------");
        System.out.println("map:\n" + map);
        // 此处想达到copyMap1数据为map中的数据不变
        System.out.println("浅复制。。。。。");
        Map<String, Object> copyMap1 = map;// 浅复制，只是引用给了copyMap,map中数据改变,copyMap数据也会改变
        map.put("basicType", 200);
        System.out.println("map:\n" + map);
        System.out.println("copyMap1:\n" + copyMap1);
    }

    @Test
    public void test2(){
        // 此处想达到copyMap2数据为map中的数据不变
        System.out.println("假深复制-----改变引用类型和基本类型");
        Map<String, Object> copyMap2 = new HashMap<String, Object>();
        copyMap2.putAll(map);// 假深复制，只对基本类型可用，当list中内容发生改变时，copyMap2中数据依然会变
        map.put("basicType", 300);
        list.add(300);
        System.out.println("map:\n" + map);
        System.out.println("copyMap2:\n" + copyMap2);
    }

    @Test
    public void test3(){
        // 此处想达到copyMap3数据为map中的数据不变
        System.out.println("深复制---使用序列化进行深拷贝");
        HashMap<String, Object> copyMap3 = new HashMap<>();
        copyMap3 = clone(map);
        map.put("basicType", 400);
        list.add(400);
        System.out.println("map:\n" + map);
        System.out.println("copyMap3:\n" + copyMap3);
    }

    /**
     * 对象深度克隆---使用序列化进行深拷贝
     *
     * @param obj
     * 要克隆的对象
     * @return
     * 注意：
     * 使用序列化的方式来实现对象的深拷贝，但是前提是，对象必须是实现了 Serializable接口才可以，Map本身没有实现
     * Serializable 这个接口，所以这种方式不能序列化Map，也就是不能深拷贝Map。但是HashMap是可以的，因为它实现了Serializable。
     */
    public static <T extends Serializable> T clone(T obj) {
        T clonedObj = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            clonedObj = (T) ois.readObject();
            ois.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return clonedObj;
    }




}
