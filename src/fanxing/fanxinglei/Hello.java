package fanxing.fanxinglei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Package: fanxing.fanxinglei
 * @ClassName: Hello
 * @Author: lujieni
 * @Description: 1
 * @Date: 2021-02-22 11:15
 * @Version: 1.0
 */
public class Hello {
     public static <T extends Comparable<T>> void mySort1(List<T> list){
             Collections.sort(list);
     }

     public static <T extends Comparable<? super T>> void mySort2(List<T> list){
          Collections.sort(list);
     }

    public static void main(String[] args) {
        // 创建一个 Animal List
         List<Animal> animals = new ArrayList<Animal>();
         animals.add(new Animal(25));
         animals.add(new Dog(35));



        // 创建一个 Dog List
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(5));
        dogs.add(new Dog(18));

        // mySort1(dogs); 报错 理由  Comparable<Dog> comparable = new Dog(); Dog类并没有实现Comparable<Dog>
        mySort2(dogs);
    }
}



class Animal implements Comparable<Animal> {
      protected int age;
      public Animal(int age) {
            this.age = age;
      }

      //使用年龄与另一实例比较大小
      @Override
      public int compareTo(Animal other) {
          return this.age - other.age;
      }
}

class Dog extends Animal {
    public Dog(int age) {
        super(age);
    }
}