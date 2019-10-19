package innnerclass;

/**
 * 测试静态内部类
 */
public class TestPerson {

    public static void main(String[] args) {
        /*
           创建外部类的时候不会自动创建静态内部类实例
         */
        //Person person= new Person();

        /*
            2个对象不相等,创建静态内部类不会构造外部类对象
            静态代码块的代码只会执行一次
         */
         /*
           Person.Hope hope1 = new Person.Hope();
           Person.Hope hope2 = new Person.Hope();
           System.out.println(hope1 == hope2);
         */

        Person.Hope hope = new Person.Hope();
        String name = hope.getName();
        System.out.println(name);

    }

}
