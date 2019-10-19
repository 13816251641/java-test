package jichen;

/**
 * 子类调用父类的方法,执行主体还是子类
 */
public class CeShiToString {
	public static void main(String[] args) {
          Father f=new Son();
          /*子类覆写了父类的toString方法,所以这里调用的子类的方法,但执行类是jichen.Son 子类*/
          System.out.println(f.toString());
          Father f1=new Father();
          /*调用父类自己的toString方法,执行类是jichen.Father类*/
          System.out.println(f1.toString());
	}
}

class Father {
	@Override
	public String toString() {
		return this.getClass().getName();
	}
}
class Son extends Father {
	@Override
	public String toString() {
		return super.toString();
	}
}