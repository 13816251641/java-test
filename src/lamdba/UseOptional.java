package lamdba;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Optional的测试和使用
 * orElseGet 与 orElse 方法的区别在于，orElseGet 方法传入的参数为一个 Supplier 接口的实现
 * —— 当 Optional 中有值的时候，返回值；当 Optional 中没有值的时候，返回从该 Supplier 获得的值。
 */
public class UseOptional {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("陆捷旎");
        List<String> strings = Arrays.asList("睡觉", "游戏", "电影");//小彩蛋string不能插入数据
        strings.forEach(s ->{
            List<String> hobbys = Optional.ofNullable(p.getHobbys()).orElseGet(() -> {
                /*第一次肯定为空,就new一个并放入person中*/
                List<String> list = new ArrayList<>();
                p.setHobbys(list);
                return list;
            });
            hobbys.add(s);
        });
        System.out.println(p.getHobbys());
    }
}

@Data
class Person{
    private String name;
    private List<String> hobbys;
}




