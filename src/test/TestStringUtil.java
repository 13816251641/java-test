package test;

import org.junit.Test;
import org.springframework.util.StringUtils;

/**
 * @Auther lujieni
 * @Date 2020/6/19
 */
public class TestStringUtil {

    @Test
    public void test(){
        String content = "";
        boolean result = StringUtils.isEmpty(content);
        System.out.println(result);

    }
}
