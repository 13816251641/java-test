package yufaxijie.duixiangcopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    对象的克隆:
        1.如果一个对象需要调用clone的方法克隆,那么该对象所属的类必须实现Cloneable接口。
        2.Cloneable接口只不过是一个标识接口而已,没有任何方法。
        3.clone()方法来自于父类Object
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Cloneable{
    private String name;
    private Address address;
    private int age;

    /*
       覆盖了父类的方法,可见性可以扩大:protected->public
       protected:本包及其子类
       方法的覆盖与否和返回类型有关系
     */
    @Override
    public Person clone() throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        person.setAddress(address.clone());
        return person;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", age=" + age +
                '}';
    }
}

@Data
@AllArgsConstructor
class Address implements Cloneable {
    private String name;

    @Override
    public Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }
}
