package dailimoshi.dongtaidaili;

/**
 * @Auther ljn
 * @Date 2019/11/28
 * 动态代理的目标对象必须要实现接口!!!
 */
public class RedisCache implements CacheManager {

    @Override
    public String save(String content) {
        System.out.println("redis save "+content);
        return content;
    }
}
