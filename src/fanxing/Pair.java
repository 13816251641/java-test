package fanxing;

/**
 * 测试泛型的上下界的demo,具体请看TestPair类
 * @param <T>
 */
public class Pair<T> {
    private  T t;
    public void setFirst(T t){
        this.t=t;
        System.out.println(t);
    }
    public T getFirst(){
        return this.t;
    }
    public Pair(T t){
        this.t=t;
    }
}
