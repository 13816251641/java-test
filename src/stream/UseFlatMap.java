package stream;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import yufaxijie.duixiangcopy.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Package: stream
 * @ClassName: UseFlatMap
 * @Author: lujieni
 * @Description: 使用flatMap
 * @Date: 2021-01-25 13:39
 * @Version: 1.0
 */
public class UseFlatMap {

    @Test
    public void test1(){
        String[] words = new String[]{"Hello","World"};
        List<String[]> result = Arrays.stream(words).map(word -> word.split("")).distinct().collect(Collectors.toList());
        result.forEach(e->{
            System.out.println(Arrays.toString(e));
        });
    }

    @Test
    public void test2(){
        String[] words = new String[]{"Hello","World"};
        List<String> result = Arrays.stream(words).map(e -> e.split("")).flatMap(e -> {
            return Arrays.stream(e);
        }).distinct().collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void test3(){
       String content = "abcde";
        String[] split = content.split("");
        System.out.println(Arrays.toString(split));
    }

    @Test
    public void test4(){
        String[] words = new String[]{"Hello","World"};
        List<String> collect = Arrays.stream(words).flatMap(e -> {
            String[] split = e.split("");
            return Arrays.stream(split);
        }).collect(Collectors.toList());
        System.out.println(collect);
    }

    /*
        如果list中的item又包含了list,你想要得到所有并放入一个
        list中,那么就要使用flatMap
     */
    @Test
    public void test5(){
      List<DataCarrier> list = new ArrayList<>();
      DataCarrier a = new DataCarrier();
      a.setList(Arrays.asList("a","b"));
      DataCarrier b = new DataCarrier();
      b.setList(Arrays.asList("1","2"));
      list.add(a);
      list.add(b);

/*      List<String> result = list.stream().map(e -> e.getList()).flatMap(e -> e.stream()).collect(Collectors.toList());
      System.out.println(result);*/

        List<String> result = list.stream().flatMap(e -> {
            return e.getList().stream().filter(g->{
               if(g.equals("1")){
                    return true;
                }
               else{
                    return false;
                }
            });
        }).collect(Collectors.toList());
        System.out.println(result);


    }

}

@Data
class DataCarrier{
    private List<String> list;



}

