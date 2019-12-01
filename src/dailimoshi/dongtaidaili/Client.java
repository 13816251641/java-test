package dailimoshi.dongtaidaili;

import java.lang.reflect.Proxy;

/**
 * @Auther ljn
 * @Date 2019/11/28
 * 使用动态代理
 */
public class Client {

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
        //cacheManager.show();
        //hello

    }
}
