package fanxing.getGenericSuperclass;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Fruit泛型类如何获得泛型T的类信息,注意在本类使用
 * 是会报错,需要有一个子类继承Fruit类才有用
 * @param <T>
 */
public class Fruit<T>{

    private Class<T> entity;

    public Fruit(){
        System.out.println("Fruit");
        Type[] types = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments();
        this.entity=(Class<T>) types[0];
        System.out.println(types[0]);
    }

    public static void main(String[] args) {
        Fruit<String> fruit = new Fruit<>();
    }
}
