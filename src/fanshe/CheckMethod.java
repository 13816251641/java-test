package fanshe;

import java.lang.reflect.Method;

public class CheckMethod {
	
	public static void main (String[] args) throws Exception {
		Class<?> userClass = UserEntity.class;
		UserEntity userEntity = (UserEntity)userClass.newInstance();
		Method declaredMethod = userClass.getDeclaredMethod("repay",int.class);
		declaredMethod.setAccessible(true);
		declaredMethod.invoke(userEntity,30);
		
	}

}



class UserEntity {    
    private int money = 10000;
    
    //借钱方法
    private int getMoney(){
        System.out.println("你借了 " + money + "元！");
        return money;
    }
    //还钱方法，单个参数
    private void repay(int money){
        System.out.println("你还了 " + money + "元！");
    }
    //还钱方法，多个参数
    private void repay(String userName,int money){
        System.out.println(userName+ " 还了 " + money + "元！");
    }
}
