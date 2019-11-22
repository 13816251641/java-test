package fanshe;

import lombok.Data;

import java.lang.reflect.Method;

/**
 * 利用反射调用方法
 */
public class CheckMethod {
	
	public static void main (String[] args) throws Exception {
		Class<?> userClass = UserEntity.class;
		UserEntity userEntity = (UserEntity)userClass.newInstance();
		Method declaredMethod = userClass.getDeclaredMethod("repay",int.class);
		/* private方法需要加 */
		declaredMethod.setAccessible(true);
		/* null 因为调用方法是void的 */
        Object invoke = declaredMethod.invoke(userEntity, 30);
        declaredMethod.setAccessible(false);
	}

}


@Data
class UserEntity {
    private String userName;
    private int userAge;

    private final int money = 10000;

    //借钱方法
    public int getMoney(){
        System.out.println("你借了 " + money + "元！");
        return money;
    }
    //还钱方法，单个参数
    private void repay(int money){
        System.out.println("你还了 " + money + "元！");
    }
    //还钱方法，多个参数
    public void repay(String userName,int money){
        System.out.println(userName+ " 还了 " + money + "元！");
    }
}
