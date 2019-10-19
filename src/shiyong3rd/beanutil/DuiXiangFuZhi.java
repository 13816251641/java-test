package shiyong3rd.beanutil;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Arrays;
import java.util.List;


/**
   基于apache-commons-beanutils的BeanUtils.copyProperties的使用
   BeanUtils.copyProperties()可以在一定范围内进行类型转换，同时还要注意一些不能转换时候，会将默认null值转化成0;
   Property.copyProperties()则是严格的类型转化，必须类型和属性名完全一致才转化。
   对于null的处理：PropertyUtils支持为null的场景；BeanUtils对部分属性不支持null，具体如下：
   a.  java.util.Date类型不支持,但是它的子类java.sql.Date是被支持的。java.util.Date直接copy会报异常；
   b.  Boolean，Integer，Long等不支持，会将null转化为0；
   c.  String支持，转化后依然为null。
   (在1.9版本下测试BeanUtils支持null)

   BeanUtils.copyProperties(t,s); 实现对象之间的拷贝:Object dest<---Object orig


 */
public class DuiXiangFuZhi {
    public static void main(String[] args) throws  Exception {
        /*对象拷贝*/
        Source s = new Source();
        s.setName("abc");
        s.setAge(28);
        Target t = new Target();
        try {
            /*
               在1.9版本下source中存在的字段必须出现在target中,否会直接抛错,
               此外包装类型和基本类型可以互转
             */
            BeanUtils.copyProperties(t,s);
            System.out.println(t);
        } catch (Exception e){
            e.printStackTrace();
        }

     /*
        BeanUtils不能直接拷贝诸如String,Long等原生元素,List必须位于成员变量中
        List<String> list = Arrays.asList("a","b");
        List<String> o = (List<String>)BeanUtils.cloneBean(list);
        System.out.println(o);
      */

    }



}
