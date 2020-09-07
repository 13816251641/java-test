package stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UseStream {

    /**
     * 测试中断lamada中的循环
     */
    @Test
    public void testBreakLambda(){

        //lamada表达式中foreach使用break
        List<String> c = Arrays.asList("6666", "7777", "8888", "9999");
        c.stream().forEach(str ->{
            if("8888".equals(str)){
                /*
                   1.return在lambda的循环中代表:跳出当前循环,继续下一轮
                   2.在lambda的循环中不允许使用break
                 */
                return;
            }
            System.out.println(str);
        });

        System.out.println("-------------------");


        List<String> a  = new ArrayList<>();
        a.add("1111");
        a.add("2222");
        a.add("3333");
        a.add("4444");
        for(String str:a){
            if("3333".equals(str)){
                break;   //正常跳出循环,后面的-------------------会被执行
            }
            System.out.println(str);
        }

        System.out.println("-------------------");

        List<String> b  = new ArrayList<>();
        b.add("1111");
        b.add("2222");
        b.add("3333");
        b.add("4444");
        for(String str:b){
            if("3333".equals(str)){
                /* 这里的return会跳出循环同时后面打印c的语句也不会执行!!! */
                return;
            }
            System.out.println(str);
        }
        System.out.println("c");
    }
}