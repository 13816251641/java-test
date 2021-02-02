package stream;

import lombok.Data;
import org.junit.Test;

import java.util.function.Function;

/**
 * @Package: stream
 * @ClassName: UseHello
 * @Author: lujieni
 * @Description: 1
 * @Date: 2021-02-02 13:40
 * @Version: 1.0
 */
public class UseHello {

    @Test
    public void test(){
        Hello<? super Son>  c = e->{
            System.out.println("hello");
        };//赋值状态

        c.show(new Son());//使用状态下只能是Son或者Son的子类
        c.show(new GrandSon());
        //c.show(new Father());
    }

    /**
     * @Description: 不使用lambda表达式
     * @param
     * @return:
     * @Author: lujieni
     * @Date: 2021/2/2
     */
    @Test
    public void test2(){
        Hello<? super Son>  c = new Hello<Father>() {  //赋值,必须是Son或者Son的父类
            @Override
            public void show(Father father) {


            }
        };
        c.show(new Son());//使用 只能传Son或者Son的子类
    }

    @Test
    public void test3(){
        show(e->{  //赋值
            e.cry();
            return "a";
        });
    }


    private <T> void show(Function<? super Son,String> f){
        f.apply(new GrandSon());//使用的时候只能放入Son或者Son的子类
        f.apply(new Son());
    }
}

@Data
class Father{

    public void eat(){

    }

}

@Data
class Son extends Father{

    public void cry(){

    }

}

@Data
class GrandSon extends Son{

    public void cry123(){

    }

}