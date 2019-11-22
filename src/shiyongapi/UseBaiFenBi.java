package shiyongapi;

import java.text.NumberFormat;

/**
 * @Auther ljn
 * @Date 2019/11/22
 *
 * 求2个数的百分比,保留2位小数
 *
 */
public class UseBaiFenBi {

    public static void main(String[] args) {
        show(1,7);

    }

    public static void show(int num1,int num2){
        /*创建一个数值格式化对象*/
        NumberFormat numberFormat = NumberFormat.getInstance();
        /*设置精确到小数点后2位*/
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format((float) num1 / (float) num2 * 100);
        System.out.println("num1和num2的百分比为:" + result + "%");
    }


}
