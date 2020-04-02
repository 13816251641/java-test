package jihe;

import org.junit.Test;

import java.util.ArrayList;
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
