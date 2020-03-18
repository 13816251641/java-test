package yufaxijie.learninterface;

public interface MyInterface {

    String name ="lujieni"; //接口中的属性都是静态的,这一点导致我们还是会用骨架抽象类

    default void show(){
        System.out.println(name);
    }


    /*
        Object类中方法（如equals 和 hashCode ）的行为，但不允许为它们提供默认方法,这一点
        会导致我们还是会用骨架抽象类

        default int hashCode() {
        return 1;
        }
     */


}
