package exceptionprocess;

import lombok.extern.slf4j.Slf4j;

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
         System.out.println("test exception");
         try{
             m = 899 / 0;
         }catch (Exception e){
            log.error("出现异常了!!!",e);
         }

    }
}
