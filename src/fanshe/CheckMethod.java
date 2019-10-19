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
    
    //��Ǯ����
    private int getMoney(){
        System.out.println("����� " + money + "Ԫ��");
        return money;
    }
    //��Ǯ��������������
    private void repay(int money){
        System.out.println("�㻹�� " + money + "Ԫ��");
    }
    //��Ǯ�������������
    private void repay(String userName,int money){
        System.out.println(userName+ " ���� " + money + "Ԫ��");
    }
}
