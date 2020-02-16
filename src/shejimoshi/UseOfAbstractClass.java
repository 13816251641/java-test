package shejimoshi;

/**
 * @Auther ljn
 * @Date 2020/2/16
 * abstract的使用意义
 * 有了抽象类,我们就不需要实现接口中所有的方法
 */
//接口
interface Window{
    void draw();
    void putColor();
    void setPosition();
}

//类只实现了接口的2个方法,所以它必须是抽象的
public abstract class UseOfAbstractClass implements Window {
     public void draw(){}
     public void putColor(){}
}


class Aw extends UseOfAbstractClass{
    @Override
    public void setPosition() {

    }
}

