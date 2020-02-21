package gainian;

/**
 * @Auther ljn
 * @Date 2019/12/23
 *
 * 测试构造代码块调用顺序
 * java编译器编译一个java源文件的时候，会把成员变量的声明语句提前至一个类的最前端。
 */
public class GouZaoCodeDiaoYongShunXu {

    //构造函数
    public GouZaoCodeDiaoYongShunXu(){   //构造函数
        //i = 300000000;
    }

    //构造代码块   //构造代码块的初始化
    {
        i = 200000000;
    }

    int i = 100000000;	 //成员变量的显初始化



    /*
       这里i到底为1****还是2****取决于代码赋值的顺序!!!
     */
    public static void main(String[] args)
    {
        GouZaoCodeDiaoYongShunXu d = new GouZaoCodeDiaoYongShunXu();
        System.out.println("i = "+d.i);
    }
}
