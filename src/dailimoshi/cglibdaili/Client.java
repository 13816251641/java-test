package dailimoshi.cglibdaili;

/**
 * @Auther ljn
 * @Date 2019/11/28
 * 测试cglib代理,子类代理
 */
public class Client {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        UserDao proxyInstance =(UserDao) new ProxyFactory(userDao).getProxyInstance();
        proxyInstance.save();
    }
}
