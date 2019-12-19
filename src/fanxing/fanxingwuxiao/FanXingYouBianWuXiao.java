package fanxing.fanxingwuxiao;

import java.util.ArrayList;

/**
 * 泛型写在右边是无效的,无法约束代码
 */
public class FanXingYouBianWuXiao {
    public static void main(String[] args) {
        ArrayList list = new ArrayList<String>();
        list.add(123);
        list.forEach(i->{
            System.out.println(i);
        });

    }

}
