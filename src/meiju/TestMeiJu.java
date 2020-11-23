package meiju;

/**
 * 测试枚举类
 */
public class TestMeiJu {

    public static void main(String[] args) {
        MessageStateEnum a = MessageStateEnum.OK_ELEMENT;
        //needEnum(a);
        MessageStateEnum b = MessageStateEnum.toEnum("error");
        System.out.println(b);//ERROR_ELEMENT
        String status = MessageStateEnum.getStatus(11);
        System.out.println(status);//ok
    }



    private static void needEnum(MessageStateEnum mse){
        System.out.println(mse);//OK_ELEMENT (枚举变量的名称) -> String类型
        System.out.println(mse.getNum());//11
        System.out.println(mse.getStatus());//ok
        /* 枚举对象的==和equals方式是一个作用看源码可知 */
        if(mse == MessageStateEnum.OK_ELEMENT){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }




}
