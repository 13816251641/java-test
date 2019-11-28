package shejimoshi;

/**
 * @Auther ljn
 * @Date 2019/11/28
 */
public class RedisCache implements CacheManager{

    @Override
    public void save(String content) {
        System.out.println("redis save "+content);
        throw new RuntimeException();
    }
}
