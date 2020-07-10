package date;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther lujieni
 * @Date 2020/5/26
 */
public class UseCalendar {

    /**
     * java秒数减1秒的代码
     */
    @Test
    public void use(){
        Date now = new Date();
        System.out.println(now);// Tue Jun 09 14:09:19 CST 2020
        Calendar instance = Calendar.getInstance();
        instance.setTime(now);
        instance.add(Calendar.SECOND,-1);
        System.out.println(instance.getTime());// Tue Jun 09 14:09:18 CST 2020
    }

    /**
     * 获取任意一个月的最后一天
     */
    @Test
    public void use2() {
        Calendar calendar = Calendar.getInstance();
        // 假设求6月的最后一天
        int currentMonth = 6;
        // 先求出7月份的第一天，实际中这里6为外部传递进来的currentMonth变量
        calendar.set(calendar.get(Calendar.YEAR), currentMonth, 1);

        calendar.add(Calendar.DATE, -1);

        // 获取日
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("6月份的最后一天为" + day + "号");
    }

     @Test
    public void use3(){
      // 获取今年的天数 2020是闰年
      int daysOfThisYear = LocalDate.now().lengthOfYear();
      System.out.println(daysOfThisYear);
     }




}
