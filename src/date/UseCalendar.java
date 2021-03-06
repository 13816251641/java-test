package date;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
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
        // 假设求6月的最后一天 月份的范围为0~11 6代表7月
        int currentMonth = 6;
        // 先求出7月份的第一天，实际中这里6为外部传递进来的currentMonth变量
        calendar.set(calendar.get(Calendar.YEAR), currentMonth, 1);

        calendar.add(Calendar.DATE, -1);//当前天数-1

        // 获取日
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("6月份的最后一天为" + day + "号");
    }

    /**
     * 获取昨天16点的时间
     */
    @Test
    public void getYesterday16PM() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,16);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MILLISECOND,0);
        /*
            将日期加1，这通过cal.add(Calendar.DATE,1)就可以实现
         */
        c.add(Calendar.DATE,-1);
        System.out.println(c.getTime());
    }


    /**
     *
     */
    @Test
    public void use3(){
      // 获取今年的天数 2020是闰年
      int daysOfThisYear = LocalDate.now().lengthOfYear();
      System.out.println(daysOfThisYear);
     }


     /**
      * @Description: 计算某2天相差的天数
      * @return:
      * @Author: lujieni
      * @Date: 2020/12/9
      */
    @Test
    public void use4() throws Exception{
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

         Date date1 = sdf.parse("2020-12-31");
         Date date2 = sdf.parse("2021-01-01");

         Calendar cal1 = Calendar.getInstance();
         cal1.setTime(date1);

         Calendar cal2 = Calendar.getInstance();
         cal2.setTime(date2);

         int day1 = cal1.get(Calendar.DAY_OF_YEAR);
         int day2 = cal2.get(Calendar.DAY_OF_YEAR);

         int year1 = cal1.get(Calendar.YEAR);
         int year2 = cal2.get(Calendar.YEAR);

         if (year1 != year2) {  //bu同年
             int timeDistance = 0;
             for (int i = year1; i < year2; i++) {
                 if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {  //闰年
                     timeDistance += 366;
                 } else {  //平年
                     timeDistance += 365;
                 }
             }
             System.out.println("bu同年差"+ (timeDistance + (day2 - day1)));
         } else { //同一年
             System.out.println("同一年差"+ (day2 - day1));
         }
     }



    @Test
    public void use5() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,15);//15天后是几号
        Date time = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(time);
        System.out.println(format);

    }

    /**
     * @Description:除非重新调用getTime,否则对于calendar的任何修改都不会影响到Date
     * @param
     * @return: void
     * @Author: lujieni
     * @Date: 2020/12/14
     */
    @Test
    public void use6() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,4);//凌晨4点
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MILLISECOND,0);

        Date four = c.getTime();
        System.out.println(four);

        c.add(Calendar.DATE, -1);
        System.out.println(four);
    }


    /**
     * @Description:利用before进行比较时间Date对象的先后
     * @param
     * @return:
     * @Author: lujieni
     * @Date: 2020/12/14
     */
    @Test
    public void use7() {
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.HOUR_OF_DAY,4);//凌晨4点
        c1.set(Calendar.MINUTE,0);
        c1.set(Calendar.SECOND,0);
        c1.set(Calendar.MILLISECOND,0);

        Calendar c2 = Calendar.getInstance();
        c2.set(Calendar.HOUR_OF_DAY,4);//凌晨4点00分01秒
        c2.set(Calendar.MINUTE,0);
        c2.set(Calendar.SECOND,1);
        c2.set(Calendar.MILLISECOND,0);

        if(c1.before(c2)){
            System.out.println("c1早于c2");
        }else{
            System.out.println("c2早于c1");
        }

    }

    @Test
    public void use8() {
        String photo = "/pdf/CCEI/2021-01-14/es3000008050433.png";
        String fileName = photo.substring(photo.lastIndexOf("/")+1);
        String photoUrl = photo.substring(0,photo.lastIndexOf("/")+1)+System.currentTimeMillis()+"-"+fileName;

        System.out.println(fileName);
        System.out.println(photoUrl);

    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList("123,123",12).size());
    }




}
