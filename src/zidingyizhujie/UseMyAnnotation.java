package zidingyizhujie;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Auther ljn
 * @Date 2020/2/18
 * 使用自定义注解
 */
public class UseMyAnnotation {

    @Person(name="lujieni",age = 29)
    public void show(){

    }

    @Test
    public void testAnnotaions() throws Exception{
        Class<?> clazz = UseMyAnnotation.class;
        Method show = clazz.getDeclaredMethod("show");
        System.out.println(show.isAnnotationPresent(Person.class));//注解是否存在
        Person person = show.getDeclaredAnnotation(Person.class);
        System.out.println(person.name());
        System.out.println(person.age());
    }


}
