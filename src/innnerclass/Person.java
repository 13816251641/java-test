package innnerclass;

/**
 * Person是外部类,Hope是静态内部类
 */
public class Person {
    private int age =27;
    public Person(){
        System.out.println("Person");
    }

    static class Hope {
        static {
            System.out.println("Hope's inner code");
        }
        private String name="ch";
        public Hope(){
            System.out.println("Hope");
        }
        public String getName(){
            return this.name;
        }
    }




}
