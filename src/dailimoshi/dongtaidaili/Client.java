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
        RedisCache redisCache = new RedisCache();

        /* 动态代理类实例需要的handler类 */
        RedisCacheHandler redisCacheHandler = new RedisCacheHandler(redisCache);

        CacheManager cacheManager =(CacheManager) Proxy.newProxyInstance(redisCache.getClass().getClassLoader(),
                redisCache.getClass().getInterfaces(),
                redisCacheHandler);
        cacheManager.save("hello");

    }
}
