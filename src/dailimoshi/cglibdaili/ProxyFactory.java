package dailimoshi.cglibdaili;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther ljn
 * @Date 2019/11/28
 * cglib代理用到asm.jar、cglib.jar
 */
public class ProxyFactory implements MethodInterceptor {

    /*目标对象*/
    private Object object;

    public ProxyFactory(Object object){
        this.object = object;
    }

    /* 给目标对象创建一个代理对象,代理对象是目前对象的子类  */
    public Object getProxyInstance(){
        /* 1.工具类 */
        Enhancer enhancer = new Enhancer();
        /* 2.设置父类 */
        enhancer.setSuperclass(object.getClass());
        /* 3.设置回调 */
        enhancer.setCallback(this);
        /* 4.创建子类(代理对象) */
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务");
        Object value = method.invoke(object, args);
        System.out.println("提交事务");
        return value;
    }
}
