package jichen;

/**
 * 子类调用父类的方法,需要打印this.getClass().getName()的时候返回的包名+类名仍旧是子类
 */
public class CeShiShow {
	public static void main(String[] args) {
          Father f = new Son();
          /*子类覆写了父类的show方法,所以这里调用的子类的方法,执行类是jichen.Son 子类*/
          System.out.println(f.show());
          Father f1 = new Father();
          /*调用父类自己的show方法,执行类是jichen.Father类*/
          System.out.println(f1.show());
	}
}

/*
	父类
 */
class Father {
	public String show() {
		return this.getClass().getName();
	}
}

/*
	子类
 */
class Son extends Father {
	/*
		调用父类的方法
	 */
	@Override
	public String show() {
		return super.show();
	}
}