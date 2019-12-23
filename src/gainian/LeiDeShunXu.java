package gainian;


import org.junit.Test;

/**
 * @Auther ljn
 * @Date 2019/12/23
 * 类中静态和非静态的顺序
 */
public class LeiDeShunXu {
    /*
       只调用父类,子类的静态和构造代码块和构造方法都不会执行
     */
    @Test
    public void test1(){
        A a = new A();
    }

    /*
       生成子类时:父类静态->子类静态->父类构造代码块->父类构造方法->子类构造代码块->子类构造方法
     */
    @Test
    public void test2(){
        B b = new B();
    }

    /*
       类是在其任何static成员变量或static成员方法被访问时候加载,
       这里要访问A.i数据,只会加载类A的静态
     */
    @Test
    public void test3(){
        System.out.println(A.i);
    }

    /*
        这里要访问B.j数据,不仅仅会加载B类的静态,同时也会加载A类的静态
     */
    @Test
    public void test4(){
        System.out.println(B.j);
    }


    /*
       访问public static final property;这样的属性不会触发类加载机制。
     */
    @Test
    public void test5(){
        System.out.println(A.i_final);
        System.out.println(B.j_final);
    }



}


class A{

    static int i = 50;

    final  static int i_final = 50;

    static {
        System.out.println("A static block");
    }

    A(){
        System.out.println("A constructor");
    }

    {
        System.out.println("A non-static block");
    }

}

class B extends A{

    static  int j = 50;

    final  static int j_final = 50;

    static {
        System.out.println("B static block");
    }

    B(){
        System.out.println("B constructor");
    }

    {
        System.out.println("B non-static block");
    }

}

