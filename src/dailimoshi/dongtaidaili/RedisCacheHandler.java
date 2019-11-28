package dailimoshi.dongtaidaili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Auther ljn
 * @Date 2019/11/28
 */
public class RedisCacheHandler implements InvocationHandler {

    /* 这个就是我们要代理的真实对象 */
    private Object object;

    /* 给我们要代理的真实对象赋初值 */
    public RedisCacheHandler(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("方法调用之前做事情");

        /*
             当代理对象调用真实对象的方法时，
             其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
             invoke方法抛异常的话代码就结束了,如果没有捕获异常的话
         */
        Object invoke = method.invoke(object, args);

        System.out.println("方法调用之后做事情");

        return invoke;
    }
}
