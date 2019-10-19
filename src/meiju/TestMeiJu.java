package meiju;

/**
 * 测试枚举
 */
public class TestMeiJu {

    public static void main(String[] args) {

        MessageStateEnum a = MessageStateEnum.OK;
        System.out.println(a.toString());//返回OK 但a不是String类型的
        show(a.toString());

    }

    private static void show(String s){
        System.out.println(s);
    }
}
