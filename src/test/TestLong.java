package test;

/**
 * Long类型的比较
 */
public class TestLong {

    public static void main(String[] args) {
        /*
          这里很特殊的是2正好在-128<=A<=127这个范围内的，那么会去IntegerCache中取，
          既然都是去IntegerCache中去取，那么自然该对象应该是一个对象，
          那么再堆中的地址应该是一样的，所以在判读两个对象是不是== 的时候，会输出true
         */
        Long l1 = 2L;
        Long l2 = 2L;
        System.out.println(l1 == l2);//true


        /*
          其大小超过了范围：-128<=A <=127，
          那么这里会直接自己创建该对象即：new Integer(366);
         */
        Long l3 = 366L;
        Long l4 = 366L;
        System.out.println(l3 == l4);//false
    }
}
