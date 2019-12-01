package dailimoshi.dongtaidaili;

/**
 * @Auther ljn
 * @Date 2019/11/28
 * 动态代理的目标对象必须要实现接口!!!
 */
public class RedisCacheImpl implements CacheManager {

    @Override
    public String save(String content) {
        System.out.println("redis save "+content);
        show();
        return content;
    }

    @Override
    public void show() {
        System.out.println("show方法");
    }
}
