package shiyongapi;

import java.util.Date;

/**
 * @Auther ljn
 * @Date 2019/11/22
 * 判断2个日期是否相同,利用getTime()方法进行判断,
 * 因为Date里面维护了一个从1970年到现在的毫秒数
 */
public class CompareDate {

    public static void main(String[] args) throws Exception {
        Date date1 = new Date();
        Thread.sleep(10);
        Date date2 = new Date();
        compareDate(date1,date2);

    }

    private static boolean compareDate(Date date1, Date date2) {
        if (date1.getTime() > date2.getTime()) {
            System.out.println("dt1大于dt2");
            return false;
        } else if (date1.getTime() < date2.getTime()) {
            System.out.println("dt1小于dt2");
            return true;
        } else {
            System.out.println("dt1等于dt2");
            return false;
        }
    }
}
