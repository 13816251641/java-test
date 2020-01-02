package innnerclass;

/**
 * Person是外部类,Hope是静态内部类
 */
public class Person {
    public int age =27;
    private static String out="a";
    static {
        System.out.println("Person's static code");
    }
    public Person(){
        System.out.println("Person");
    }
    static class Hope {
        static {
            System.out.println("Hope's static code");
        }
        private String name="ch";
        public Hope(){
            System.out.println("Hope");
        }
        public String getName(){
            System.out.println(out);
            return "a";
        }
    }
}
