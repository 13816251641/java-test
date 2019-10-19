package test;

/**
 * Long类型的比较
 */
public class TestLong {

    public static void main(String[] args) {
        Long l1 = 2L;
        Long l2 = 2L;
        l1.longValue();
        System.out.println(l1 == l2);

        Long l3 = 366L;
        Long l4 = 366L;
        System.out.println(l3 == l4);


    }
}
