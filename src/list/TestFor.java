package list;

import org.junit.Test;

/**
 * @Package: list
 * @ClassName: TestList
 * @Author: lujieni
 * @Description: 测试for循环的语法
 * @Date: 2020-12-11 13:10
 * @Version: 1.0
 */
public class TestFor {

    @Test
    public void test1(){
        int i = 2;
        for(;i<3;i++){
            System.out.println(i);
        }
        System.out.println(i);
    }

    @Test
    public void test2(){
        String content = new String("");
        if(content != null && content != ""){
            System.out.println("aa");
        }else{
            System.out.println("bb");
        }

    }
}