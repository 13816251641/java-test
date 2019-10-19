package xiangdengbijiao;

/*
 * 因为，instanceof判断是否是某一类型的实例时，该类型可以是父类或者接口。
 * 而getclass 用于判断准确的类型。同时，在这里必须说明的是，getclass判断的是
 * 该变量实际指向的对象的类型（即运行时类型），跟声明该变量的类型无关.
 * 
 */
public class InstanceOf {
	public static void main(String[] args) {
        Father f=new Son();
        Father ff=new Father();
        Son s=new Son();
        System.out.println(ff instanceof Son);    //false
        //System.out.println(f instanceof Father);//true
        //System.out.println(f instanceof Son);   //true 
        //System.out.println(s instanceof Father);  //true
        
        
       // System.out.println(f.getClass() == ff.getClass());//false
       // System.out.println(f.getClass() == Father.class);//false
       // System.out.println(f.getClass() == Son.class);//true
		
	}
}

class Father {

}

class Son extends Father {

}
