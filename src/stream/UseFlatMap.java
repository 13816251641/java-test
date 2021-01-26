package stream;

import lombok.Data;
import org.junit.Test;
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
        /*
            1. e -> e.split("")  分别将"Hello" & "World" -> String[]  String[]
            2. e -> {            e是上面的String[]
                 return Arrays.stream(e);
               }
         */
        List<String> result = Arrays.stream(words).map(e -> e.split("")).flatMap(e -> {
            return Arrays.stream(e);
        }).distinct().collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void test2(){
       String content = "abcde";
       String[] split = content.split("");
       System.out.println(Arrays.toString(split));
    }

    /*
        如果list中的item又包含了list,你想要得到所有并放入一个list中,那么就要使用flatMap
     */
    @Test
    public void test3(){
      List<DataCarrier> list = new ArrayList<>();
      DataCarrier a = new DataCarrier();
      a.setList(Arrays.asList("a","b","c"));
      DataCarrier b = new DataCarrier();
      b.setList(Arrays.asList("1","2"));
      list.add(a);
      list.add(b);

      /*
          为了得到 a,b,c,1,2
       */
      //方法1
      List<String> result1 = list.stream().map(e -> e.getList()).flatMap(e -> e.stream()).collect(Collectors.toList());
      System.out.println(result1);

      //方法2
      List<String> result2 = list.stream().flatMap(e -> {
         return e.getList().stream();
      }).collect(Collectors.toList());
      System.out.println(result2);

    }
}

@Data
class DataCarrier{
    private List<String> list;
}

