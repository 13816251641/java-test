package stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
                   3.在lambda的循环中不允许使用continue
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


    /**
     * 测试使用stream去重
     */
    @Test
    public void test() {
        List<Dish> dishList = new ArrayList<>();
        Dish dish1 = new Dish("001", "张三");
        dishList.add(dish1);
        Dish dish2 = new Dish("001", "李四");
        dishList.add(dish2);
        Dish dish3 = new Dish("002", "王五");
        dishList.add(dish3);
        Dish dish4 = new Dish("003", "阿森纳");
        dishList.add(dish4);

        /*
          测试Collectors.toCollection方法：将结果收集到其它类型的集合中(这里是TreeSet)
          TreeSet<Dish> treeSet2 = dishList.stream()
          .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Dish::getId))));
        */

        ArrayList collect = dishList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> {
            return new TreeSet<Dish>(Comparator.comparing(e -> {
                return e.getId();
            }));
        }), e -> {
            return new ArrayList(e);
        }));
        System.out.println(collect);
    }





    /**
     * 测试使用skip api批量插入
     */
    @Test
    public void bulkInsert(){
        List<String> list = new ArrayList<>();
        int BULK_INSERT_COUNT = 5;
        for(int i=1;i<=71;i++){
            list.add(""+i);
        }
        int loopCount = list.size() % BULK_INSERT_COUNT > 0 ? list.size() / BULK_INSERT_COUNT + 1 : list.size() / BULK_INSERT_COUNT;
        for ( int i = 0; i < loopCount; i++){
            List<String> collect = list.stream().skip(i * BULK_INSERT_COUNT).limit(BULK_INSERT_COUNT).collect(Collectors.toList());
            System.out.println(collect);
        }
    }


    /**
     * 对这个集合的流，做一系列的中间操作后，可以调用findFirst，返回集合的第一个对象
     * ifPresent有的话就执行,没有就不执行
     */
    @Test
    public void useFindFirst(){
        List<String> list = Arrays.asList("a","b","b","c","a");
        list.stream().filter(e->Objects.equals(e,"b1")).findFirst().ifPresent(e->{
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(e);
        });
        System.out.println("outer");
        //和ifPresent里的代码是同步的,ifPresent里的代码不执行完外面的代码是不会执行的
    }


    /**
     * anyMatch表示，判断的条件里，任意一个元素成功，返回true
     * 如果是空的list,就返回false !!!
     *
     */
    @Test
    public void useAnyMatch(){
        List<String> list = Arrays.asList();
        System.out.println(list.size());//0
        boolean result = list.stream().anyMatch(e -> Objects.equals(e, "b"));//false
        System.out.println(result);
    }

    @Test
    public void test11(){
        LocalDate localDate = LocalDate.now();
        System.out.println(String.valueOf(localDate.getMonthValue()));
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Dish {

    private String id;

    private String name;

}




