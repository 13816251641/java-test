package gainian;

import org.junit.Test;

/**
 * @Auther ljn
 * @Date 2020/2/21
 * Class.forName和ClassLoader的区别
 */
public class DifferenceBetweenClassForNameAndClassLoader {
    /**
     * ClassLoader的loadClass并没有对类进行初始化,只是把类加载到了虚拟机中。
     */
    @Test
    public void useClassLoader(){
        try {
            ClassLoader.getSystemClassLoader().loadClass("gainian.ClassForName");
            System.out.println("#########-------------结束符------------##########");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
       Class.forName加载类时将类进了初始化
     */
    @Test
    public void useClassForName(){
        try {
            Class<?> clazz = Class.forName("gainian.ClassForName");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class ClassForName {
    //静态代码块
    static {
        System.out.println("执行了静态代码块");
    }
    //静态变量
    private static String staticFiled = staticMethod();

    //赋值静态变量的静态方法
    public static String staticMethod(){
        System.out.println("执行了静态方法");
        return "给静态字段赋值了";
    }

}
