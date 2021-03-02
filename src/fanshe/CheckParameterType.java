package fanshe;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @Package: fanshe
 * @ClassName: CheckParameterType
 * @Author: lujieni
 * @Description: 反射获取泛型
 * @Date: 2021-03-02 17:30
 * @Version: 1.0
 */
public class CheckParameterType {

    public void show(Map<String,Integer> map,String a){

    }

    public List<String> cry(){
        return null;
    }


    @Test
    public void test01() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz = Class.forName("fanshe.CheckParameterType");
        Method show = clazz.getMethod("show", Map.class,String.class);
        Type[] genericParameterTypes = show.getGenericParameterTypes();
        for (Type type:genericParameterTypes) {
            if(type instanceof ParameterizedType){
                Type[] actualType = ((ParameterizedType) type).getActualTypeArguments();
                for (Type element : actualType) {
                    System.out.println(element);//class java.lang.String |  class java.lang.Integer
                }
            }else{
                System.out.println(type);//打印非泛型入参 class java.lang.String
            }
        }
    }

    @Test
    public void test02() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz = Class.forName("fanshe.CheckParameterType");
        Method cry = clazz.getMethod("cry", null);
        Type genericReturnType = cry.getGenericReturnType();
        if(genericReturnType instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type element : actualTypeArguments) {
                System.out.println(element);//打印每个泛型即T
            }
        }else{
            System.out.println(genericReturnType);//非泛型返回值这里打印
        }
    }




}