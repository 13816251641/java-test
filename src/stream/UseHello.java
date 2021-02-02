package stream;

import lombok.Data;
import org.junit.Test;

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

    @Test
    public void test2(){
        Hello<? super Son>  c = new Hello<Father>() {  //赋值
            @Override
            public void show(Father father) {


            }
        };
        c.show(new Son());//使用 只能传Son或者Son的子类
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