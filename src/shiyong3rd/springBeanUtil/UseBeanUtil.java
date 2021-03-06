package shiyong3rd.springBeanUtil;

import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Auther lujieni
 * @Date 2020/6/30
 * Spring实现的BeanUtils.copyProperties是浅拷贝
 * 参数名一致类型不一致不能拷贝!!!
 * int age -> Integer age ok
 * int age -> String  age ng
 * null -> null 资源对象的属性null也会拷贝到目标对象中去,要注意!!!
 */
public class UseBeanUtil {

    public static void main(String[] args) {
        Student s = new Student();
        s.setAge(28);
        StudentDTO s2 = new StudentDTO();
        BeanUtils.copyProperties(s,s2);
        System.out.println(s2);
    }

}

@Data
class Student{
    private int age;
    private Integer num;
}

@Data
class StudentDTO{
    private Integer age;
    private Integer num = 50;
}


