package innnerclass;

/**
 * Student是一个外部类,School是里面的成员内部类
 */
public class Student {
    private int age=28;
    public class School{
        int age=88;
        private String name = "lu brother";
        public School(){
            System.out.println("School");
        }
        public String getName(){
            return name;
        }
        public int getInnerAge(){
            return age;
        }
        public int getOuterAge(){
            return Student.this.age;//访问外部类的字段(重名)
        }
    }
    public Student(){
        System.out.println("Student");
    }

    public School getSchool(){
         return new School();
    }


    /**
     * 从外部类得到内部类私有的属性
     * @return
     */
    public String getInnerClassPrivateProperty(){
        return new School().name;
    }

}
