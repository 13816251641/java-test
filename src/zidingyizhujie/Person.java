package zidingyizhujie;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//方法上加注解
@Retention(RetentionPolicy.RUNTIME)//运行有效,存在class字节码文件中
public @interface Person {
    String name();
    int age();
}
