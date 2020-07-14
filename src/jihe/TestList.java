package jihe;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestList {
    /*
        person只是一个句柄,person = new Person("王五");只是把person又指向了一个新的
        对象的地址,不会影响list里面的
     */
    @Test
    public void testOne(){
        List<Person> personList = new ArrayList<>();
        Person person = new Person("张三");
        personList.add(person);//personList[0]的地址指向Person[张三]对象的内存地址
        person = new Person("王五");
        personList.add(person);
        System.out.println(personList);

    }

    /*
        使用Collection.isEmpty()使得代码更易读并且可以获得更好的性能,
        任何Collection.isEmpty() 实现的时间复杂度都是O(1)
     */
    @Test
    public void testTwo(){
        List<Object> list = new LinkedList<>();
        list.add(new String("a"));
        if(list.isEmpty()){
            System.out.println("is empty");
        }
    }

    /**
     * 在使用 Collection 接口任何实现类的 addAll()方法时，都要对输入的集合参数进行NPE判断
     */
    @Test
    public void testAddAll(){
        List<Object> list = new LinkedList<>();
        list.addAll(null);
    }


    /**
     * Collections 类返回的对象，如：emptyList()/singletonList()等都是 immutable list，
     * 不可对其进行添加或者删除元素的操作
     */
    @Test
    public void testEmptyList(){
        List<Object> list = Collections.emptyList();
        System.out.println(list.isEmpty());
        // list.add("a"); ng
        // list.get(0); ng
    }

    /**
     * 使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全一
     * 致、长度为 0 的空数组。
     * 反例：直接使用 toArray 无参方法存在问题，此方法返回值只能是 Object[]类，若强转其它类型数组将出现
     * ClassCastException 错误
     */
    @Test
    public void testToArray(){
        List<String> list = new ArrayList<>(2);
        list.add("guan");
        list.add("bao");
        String[] objects = (String[])list.toArray();//[Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
        System.out.println(objects);
    }



    static class Person{
        String name;
        private Person(String name){
            this.name=name;
        }
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
