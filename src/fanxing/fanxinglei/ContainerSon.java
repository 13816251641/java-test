package fanxing.fanxinglei;

/**
 * @Package: fanxing.fanxinglei
 * @ClassName: ContainerSon
 * @Author: lujieni
 * @Description: 1
 * @Date: 2021-02-03 15:19
 * @Version: 1.0
 *
 *
 * ContainerSon <T extends Number>
 * 泛型 T 必须继承Number才可以
 *
 * ContainerSon <T super Number> 没有这种写法!!!
 *
 */
public class ContainerSon <T extends String> extends Container<T> {

    public ContainerSon(T value) {
        super(value);
    }

}