package dailimoshi.dongtaidaili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther ljn
 * @Date 2019/11/28
 * 动态代理工厂
 * 目标对象一定要实现接口,否则不能用动态代理!!!
 */
public class ProxyFactory {
    /* 真实要代理的对象 */
    private Object object;

    public ProxyFactory(Object object){
        this.object = object;
    }

    /* 生成目标对象的代理对象  */
    public Object getProxyInstance(){
            return Proxy.newProxyInstance(
                    object.getClass().getClassLoader(),
                    object.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            System.out.println("开始事务");
                            Object value = method.invoke(object, args);
                            System.out.println("结束事务");
                            return value;
                        }
                    }
            );
    }

}
