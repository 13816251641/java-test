package fanxing.fanxingshangxiajie;

/*
   泛型的上界
   这里的返回类型是针对? extends Number 而言的,
   即Number
 */
public class FanXingShangJie<T> {

    private  T t;

    public void setFirst(T t){
        this.t=t;
    }

    public T getFirst(){
        return this.t;
    }

    public static void main(String[] args) {
        /*泛型的上界*/
        FanXingShangJie<Integer> origin = new FanXingShangJie<>();
        origin.setFirst(28);
        FanXingShangJie<? extends Number> after = origin;
        /*after.setFirst(13L);不能调用function(T t)这样的方法*/
        Number first = after.getFirst();
        System.out.println(first);
    }
}





