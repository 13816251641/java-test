package list;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther ljn
 * @Date 2020/1/6
 * list的深拷贝
 */

public class UseDeepCopy {
    /**
     * p和p1指向同一个内存地址
     */
    @Test
    public void test1(){
        Person p = new Person(27,"lujieni",new Address("上海"));
        Person p1 = p;
        System.out.println(p == p1);
    }

    /**
     * 使用clone要递归到每个对象!!!
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{
        Person person = new Person(27,"lujieni",new Address("上海"));
        Person personCopy = person.clone();
        /* 已经不是同一个对象了 */
        System.out.println(person == personCopy);
        person.setName("lisi");
        /* Address类没有实现Cloneable,导致仍旧是指针引用 */
        person.getAddress().setName("北京");
        System.out.println(personCopy);
    }


    /**
     * 通过序列化的方式,实体类要实现Serializable接口
     * @throws Exception
     */
    @Test
    public void test3() throws Exception{
        Person person = new Person(27,"lujieni",new Address("上海"));
        Person personCopy = deepCopy(person);
        /* 已经不是同一个对象了 */
        System.out.println(person == personCopy);
        person.setName("wahaha");
        person.getAddress().setName("广州");
        System.out.println(personCopy);
    }





    /**
     * 序列化这个对象再反序列化的方式,实体类要实现Serializable接口
     * @param t
     * @param <T>
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T extends Serializable> T deepCopy(T  t) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(t);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        objectInputStream = new ObjectInputStream(byteArrayInputStream);
        T copy = (T) objectInputStream.readObject();

        if (objectInputStream!=null) {
            objectInputStream.close();
        }
        if (objectInputStream!=null) {
            objectOutputStream.close();
        }
        return copy;
    }

    @Data
    @AllArgsConstructor
    static class Person implements Serializable,Cloneable{
        private Integer age;
        private String name;
        private Address address;

        @Override
        protected Person clone() throws CloneNotSupportedException {
            return (Person)super.clone();
        }
    }

    @Data
    @AllArgsConstructor
    static class Address implements Serializable{
        private String name;
    }
}


