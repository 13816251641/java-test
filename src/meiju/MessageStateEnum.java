package meiju;

import lombok.Getter;

import java.util.Objects;

/**
 * 枚举类名驼峰即可,枚举类名建议带上Enum后缀
 */
@Getter
public enum MessageStateEnum {

    /*里面的字段名一律大写,单词之间下划线分割*/
    OK_ELEMENT("ok",11,"a"),
    ERROR_ELEMENT("error",12,"b");

    private final String status;

    private final int num;

    private final String content;

    /*构造方法被默认强制是私有*/
    MessageStateEnum(String status,Integer num,String content){
        this.status=status;
        this.num = num;
        this.content = content;
    }

    /**
     *
     * @param name 查询字段
     * @return  枚举类
     */
    public static MessageStateEnum toEnum(String name) {
        for(MessageStateEnum item : MessageStateEnum.values()) {
            if(item.getStatus().equals(name)) {
                return item;
            }
        }
        //默认风格
        return null;
    }

    /**
     *
     * @param num
     * @return
     *
     * 输入num 输出String
     * num => status
     */
    public static String getStatus(Integer num) {
        for(MessageStateEnum element : MessageStateEnum.values()){
            if(Objects.equals(num,element.getNum()))
                return element.getStatus();
        }
        return null;
    }
}
