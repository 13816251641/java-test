package duixiangleixin;

/**
 * @Auther ljn
 * @Date 2020/2/13
 *
 * Integer i = n
 * 当n不在-128<= x <=127范围的时候这里会自动装箱给你new一个Integer对象
 * 当n在上述范围的时候n是从IntegerCache中读取的
 *
 *  Integer和Long的原理是一致的
 *
 */
public class TestInteger {

    public static void main(String[] args) {
        Integer i = new Integer(128);
        Integer i2 = 128;

        System.out.println(i == i2);

        Integer i3 = new Integer(127);
        Integer i4 = 127;
        System.out.println(i3 == i4);

        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6);

        Integer i7 = 127;
        Integer i8 = 127;
        System.out.println(i7 == i8);
    }
}
