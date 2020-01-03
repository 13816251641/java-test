package exceptionprocess;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Auther ljn
 * @Date 2020/1/1
 * 小周推荐异常打印方式
 * 这样可以打印出异常代码的位置
 */
@Slf4j
public class HowToReportException {
    private static int m = 0;

    public static void main(String[] args) {
        Object[] checkItems  = {"12306","98275"};
        Sample sample = new Sample();
        sample.age = 29;
        sample.name = "lujieni";
        try{
             m = 899 / 0;
         }catch (Exception e){
            //log.error("出现异常了!!! 异常数据为:"+ Arrays.toString(checkItems),e);
            /* 需要重写sample的toString方法 */
            log.error("出现异常了!!! 异常数据为:"+ sample,e);
        }

    }

    static class Sample{
        private int age;
        private String  name;

        @Override
        public String toString(){
           return "age:"+age+";name:"+name;
        }

    }
}

