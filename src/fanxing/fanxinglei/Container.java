package fanxing.fanxinglei;

/**
 * @Package: fanxing.fanxinglei
 * @ClassName: Container
 * @Author: lujieni
 * @Description:
 * @Date: 2021-02-03 15:19
 * @Version: 1.0
 */
public class Container<T> {

    private T value;

    public Container(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}