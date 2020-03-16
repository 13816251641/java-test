package yufaxijie.duixiangcopy;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
    对象的克隆:
        1.如果一个对象需要调用clone的方法克隆,那么该对象所属的类必须实现Cloneable接口。
        2.Cloneable接口只不过是一个标识接口而已,没有任何方法。
 */
@Data
@AllArgsConstructor
public class Person implements Cloneable{
    private String name;
    private Address address;

    /*
       覆盖了父类的方法,可见性可以扩大:protected->public
       protected:本包及其子类
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        person.setAddress((Address)address.clone());
        return person;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address.name=" + address.getName() +
                '}';
    }


}

@Data
@AllArgsConstructor
class Address implements Cloneable{
    private String name;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
