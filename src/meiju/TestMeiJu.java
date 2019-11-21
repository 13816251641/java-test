package meiju;

/**
 * 测试枚举类
 *
 */
public class TestMeiJu {

    public static void main(String[] args) {
        MessageStateEnum a = MessageStateEnum.OK;
        needEnum(a);
        MessageStateEnum b = MessageStateEnum.toEnum("error");
        System.out.println(b);//ERROR
    }

    private static void needEnum(MessageStateEnum mse){
        System.out.println(mse);//OK->String类型
        System.out.println(mse.getNum());//11
        System.out.println(mse.getStatus());//ok
        /*枚举对象的==和eques方式是一个作用看源码可知*/
        if(mse == MessageStateEnum.OK){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
