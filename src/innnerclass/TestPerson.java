package innnerclass;

import org.junit.Test;

/**
 * 测试静态内部类,静态内部类本质和外部类联系不大
 */
public class TestPerson {
    /**
     * 创建外部类的时候不会自动创建静态内部类实例
     */
    @Test
    public void test1(){
        Person person= new Person();
    }

    @Test
    public void test2(){
        /*
           2个对象不相等,创建静态内部类不会构造外部类
           对象(不会执行外部类的static代码和构造代码),
           静态内部类的静态代码也只会执行一次
        */
       Person.Hope hope1 = new Person.Hope();
       Person.Hope hope2 = new Person.Hope();
       System.out.println(hope1 == hope2);
    }

    /**
     *  静态内部类可以直接访问外部类的静态变量,即使它
     *  在外部类中是私有的,一旦访问外部类的静态资源,
     *  外部类的静态代码块,静态变量都会得到初始化(原本是没有的)
     */
    @Test
    public void test3(){
        Person.Hope hope = new Person.Hope();
        String name = hope.getName();
        System.out.println(name);
    }

}
