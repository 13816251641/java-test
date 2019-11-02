package jichen;

/**
 * new Person() new出来的可以是本类或者是匿名内部类
 */
public class Person {
    public void show(){
        System.out.println(this.getClass().getName());
    }

    public static void main(String[] args) {
        /*这里new了一个匿名内部类*/
        Person p = new Person(){
            @Override
            public void show(){
                System.out.println(this.getClass().getName());
            }
        };
        p.show();
    }
}
