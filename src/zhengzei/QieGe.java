package zhengzei;

/*
   利用正则切割练习
 */
public class QieGe {

    public static void main(String[] args) {
        splitDemo2();
    }

    /*
       根据重叠词进行切割
     */
    public static void splitDemo2()
    {
        String str = "sdqqfgkkkhjppppkl";
        String[] arr = str.split("(.)\\1+");
        //如果正则的内容需要被复用,那么需要对正则的内容进行分组,分组的目的
        //是为了提高正则的复用性
        for(String s : arr)
        {
            System.out.println(s);
        }
    }

    /*
       根据空格对一段字符串进行切割
     */
    public static void splitDemo()
    {
        String str = "aa.bb.cc";
        str = "-1     99    4    23";
        String[] arr = str.split(" +");
        for(String s : arr)
        {
            System.out.println(s);
        }
    }
}
