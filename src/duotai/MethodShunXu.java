package duotai;

import java.util.Date;

/**
 * 多态方法执行顺序
 * 多态加载顺序优先级是this.show(o)->supper.show(o)->this.show(spper(o))->supper.show(spper(o))
 * 即先在本类中找同名的方法且同类型的参数,再去父类中去寻找同名的方法且同类型的参数,接着在本类中
 * 寻找同名的方法且能向上转型的参数,最后再父类中去寻找同名的方法且能向上转型的参数
 */
public class MethodShunXu {
      public static void main(String[] args) {
    	  A a1 = new A();
          A a2 = new B();
          B b = new B();
          C c = new C();
          D d = new D();
          
          System.out.println("1--" + a1.show(b));//A and A
          System.out.println("2--" + a1.show(c));//A and A
          System.out.println("3--" + a1.show(d));//A and D
          System.out.println("4--" + a2.show(b));//B and A 本来是A and A 最后变为B and A 因为子类覆写了
          System.out.println("5--" + a2.show(c));//B and A
          System.out.println("6--" + a2.show(d));//A and D
          System.out.println("7--" + b.show(b));//B and B
          System.out.println("8--" + b.show(c));//B and B
          System.out.println("9--" + b.show(d));//A and D

	}
}

 class A {
    public String show(D obj) {
        return ("A and D");
    }
 
    public String show(A obj) {
        return ("A and A");
    } 
 
}
 
 class B extends A{
    public String show(B obj){
        return ("B and B");
    }
    
    @Override
    public String show(A obj){
        return ("B and A");
    } 
}
 
 class C extends B{
 
}
 
 class D extends C{
 
}
 
