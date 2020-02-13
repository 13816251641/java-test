package fanxing.fanxingshangxiajie;

/*
   泛型的下界
   个人认为要从原始类的角度看就明白其中的缘由
   这里的返回类型是针对 ? super Grandson 而言的,
   即Grandson
 */
public class FanXingXiaJie<T> {

    private  T t;

    public void setFirst(T t){
        this.t=t;
    }

    public T getFirst(){
        return this.t;
    }

    public static void main(String[] args) {
        FanXingXiaJie<Son> origin = new FanXingXiaJie<>();
        origin.setFirst(new Son());
        FanXingXiaJie<? super Grandson> after = origin;
        after.setFirst(new Grandson()); //只能传入Grandson或者它的子类型
        Object first = after.getFirst();//不能保证返回对象的类型,只能把它赋给一个Object
        System.out.println(first.getClass().getName());
    }
}

class Father{

}

class Son extends Father {

}

class Grandson extends Son {

}


