package yufaxijie.duixiangcopy;

import org.junit.Test;

public class TestCopy {

    /*
        使用覆写Object的clone方法来实现拷贝,如果要实现深拷贝
        则每个成员类都要实现clone方法,很烦的
     */
    @Test
    public void show01() throws Exception{
        Person person1 = new Person("张三",new Address("上海"));
        Person person2 = (Person)person1.clone();
        System.out.println(person1 == person2);
        person2.setName("李四");
        person2.getAddress().setName("成都");
        System.out.println(person1);
        System.out.println(person2);
    }

    /*
        使用序列化方式,本身就是深拷贝
     */
    @Test
    public void show02() throws Exception{
        PersonWithSerialize person1 = new PersonWithSerialize("张三",new AddressWithSerialize("上海"));
        PersonWithSerialize person2 = person1.clone();
        System.out.println(person1 == person2);
        person2.setName("李四");
        person2.getAddressWithSerialize().setName("武汉");
        System.out.println(person1);
        System.out.println(person2);
    }
}
