package duixiangleixin;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Auther lujieni
 * @Date 2020/6/23
 */
public class TestBigDecimal {

    @Test
    public void test(){
        BigDecimal num1 = new BigDecimal(0);
        BigDecimal num2 = num1.add(new BigDecimal(5));
        System.out.println(num1);//仍就是0
        System.out.println(num2);//用num2去接才是5

    }




}
