package fanxing.fanxingshangxiajie;

import java.time.LocalDate;

/**
 * @Package: fanxing.fanxingshangxiajie
 * @ClassName: DateInterval
 * @Author: lujieni
 * @Description: 桥方法
 * @Date: 2021-02-20 14:47
 * @Version: 1.0
 */
public class DateInterval extends Pair<LocalDate> {

    /*
        不能这样子玩,和父类:void setFirst(T t)冲突
        public void setFirst(Object localDate){
            super.setFirst(LocalDate.now());
        }
    */

    /*
        和父类:void setFirst(T t)是2个不同的方法,所以不冲突
     */
    public void setFirst(LocalDate localDate){
        super.setFirst(localDate);
    }


    public static void main(String[] args) {
        DateInterval dateInterval = new DateInterval();
        Pair<LocalDate> pair = dateInterval;
        pair.setFirst(LocalDate.now());

    }


}