package fanxing.fanxingshangxiajie;

/**
 * 测试泛型的上下界的demo,具体请看TestPair类
 * @param <T>
 */
public class Pair<T> extends Object {
    private  T t;
    public void setFirst(T t){
        this.t = t;
    }
    public T getFirst(){
        return this.t;
    }
    public Pair(T t){
        this.t = t;
    }
    public Pair(){
    }

    /*
        报错
        @Override
        public boolean equals(T a){
            return true;
        }
    */

}
