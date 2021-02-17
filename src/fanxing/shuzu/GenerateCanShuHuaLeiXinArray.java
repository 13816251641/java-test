package fanxing.shuzu;

import org.junit.Test;

/**
 * @Package: fanxing.shuzu
 * @ClassName: GenerateCanShuHuaLeiXinArray
 * @Author: lujieni
 * @Description: 构建参数化类型数组
 * @Date: 2021-02-17 15:17
 * @Version: 1.0
 */
public class GenerateCanShuHuaLeiXinArray {

    @Test
    public void test01(){
        /*
            不能创建参数化类型的数组
             Pair<String>[] table = new Pair<String> [10];
         */
    }

    @Test
    public void test02(){
        /*
            可以这样玩,但结果仍旧不安全
            因为: o[0] = new Pair<Integer>(12);
            导致 java.lang.ClassCastException
         */
        Pair<String>[] table = (Pair<String>[]) new Pair<?>[10];
        Object[] o = table;
        o[0] = new Pair<Integer>(12);
        String value = table[0].getValue();
    }


}

class Pair<T>{
    private T value;

    public Pair(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

