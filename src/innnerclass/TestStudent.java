package innnerclass;

/**
 * 测试Student外部类
 */
public class TestStudent {

    public static void main(String[] args) {
        /*
           成员内部类依附于外部类,先创建外部类实例再创建
           内部类实例,单单创建外部类实例是不会创建内部
           类实例的,如果内部类不是可见的就不能这样!!!
         */
        //Student.School school = new Student().new School();

        /*
           在外部类提供一个方法创建内部类的对象进行访问,
           如果成员内部类不是可见的就不能这样!!!
         */
        //Student.School school = new Student().getSchool();
        /*
           成员内部类访问自己的字段
         */
        //System.out.println(new Student().getSchool().getInnerAge());
         /*
           成员内部类访问外部类重名的private的字段
         */
        //System.out.println(new Student().getSchool().getOuterAge());
        /*
           外部类访问成员内部类私有的属性
         */
        String name = new Student().getInnerClassPrivateProperty();
        System.out.println(name);
    }
}
