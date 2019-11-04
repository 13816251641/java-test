package duotai;


/**
 * 多态中的相等比较
 */
public class InstanceOf {
	public static void main(String[] args) {
        Father f = new Son();
        Father ff = new Father();
        Son s = new Son();
        System.out.println(ff instanceof Son);    //false
        System.out.println(f instanceof Father);//true
        System.out.println(f instanceof Son);   //true
        System.out.println(s instanceof Father);  //true
        
        
        System.out.println(f.getClass() == ff.getClass());//false
        System.out.println(f.getClass() == Father.class);//false
        System.out.println(f.getClass() == Son.class);//true
		
	}
}

class Father {

}

class Son extends Father {

}
