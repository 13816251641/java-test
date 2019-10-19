package duotai;

/**
 *  instanceof 和 getclass 的区别
 */
public class InstanceofAndGetclass {

    public static void main(String[] args) {
        Animal aa=new Dog ();//父类的对象指向子类的引用
        Animal a=new Animal();
        Dog d=new Dog();
        System.out.println(a instanceof Dog);      //false
        System.out.println(aa instanceof Animal);  //true
        System.out.println(aa instanceof Dog);     //true 该类型可以是父类或者接口
        System.out.println(d instanceof Animal);   //true

        System.out.println(aa.getClass() == a.getClass());//false
        System.out.println(aa.getClass() ==  Animal.class);//false
        System.out.println(aa.getClass() == Dog.class);//true

    }
}

class Animal {

}

class Dog extends Animal {

}


