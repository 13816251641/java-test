package dailimoshi.dongtaidaili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther ljn
 * @Date 2019/11/28
 * handler类必须要实现InvocationHandler接口
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
             当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的
             handler对象的invoke方法来进行调用,如果目前对象的代码抛异常而在
             这里没有捕获的话,程序戛然而止
         */
        Object value = method.invoke(object, args);

        System.out.println("方法调用之后做事情");

        /*
          如果这里写成return null,那么调用代理类的方法的时候也一直为null!!!
         */
        return value;
    }

    public static void main(String[] args) {
        /* 我们要代理的真实对象 */
        RedisCacheImpl redisCacheImpl = new RedisCacheImpl();

        /* 动态代理类实例需要的handler类 */
        RedisCacheHandler redisCacheHandler = new RedisCacheHandler(redisCacheImpl);

        CacheManager cacheManager =(CacheManager) Proxy.newProxyInstance(redisCacheImpl.getClass().getClassLoader(),
                            redisCacheImpl.getClass().getInterfaces(),
                            redisCacheHandler);
        /* 目标类方法A调用自己的B方法,B方法不会触发代理!!!*/
        String hello = cacheManager.save("hello");
        // cacheManager.show();


    }
}
