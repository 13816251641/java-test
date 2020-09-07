package threadlocal;

/**
 * @Auther ljn
 * @Date 2019/11/26
 * 使用ThreadLocal类
 */
public class UseThreadLocal {

    public static void main(String[] args) {
        /*
            ThreadLocal的set方法默认会创建一个ThreadLocalMap类,
            ThreadLocalMap类是ThreadLocal的静态内部类,然后将这个
            内部类赋值到Thread即当前线程的成员变量ThreadLocal.ThreadLocalMap threadLocals
            中去,这是创建ThreadLocalMap的过程,一个线程共用这一个
            ThreadLocalMap类,它的key是每个ThreadLocal的实例!!!
            value就是这里的av
         */
        ThreadLocal<String> tl = new ThreadLocal<>();
        tl.set("av");
        tl.get();

        ThreadLocal<String> t2 = new ThreadLocal<>();
        t2.set("miss");
        t2.get();

        System.out.println(tl.get());


    }

}
