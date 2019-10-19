package zhengzei;

/*
   正则替换练习
 */
public class TiHuan {

    public static void main(String[] args) {
        //replaceTest1();
        replaceTest2();
    }

    /*
        替换
    */
    public static void replaceTest1(){
        String str="如有需求请联系我:13556082123如有需求请联系我:13556082123如有需求请联系我:13556082123" +
                "如有需求请联系我:13556082123如有需求请联系我:13556082123如有需求请联系我:13556082123如有需求请联系我:13556082123" +
                "如有需求请联系我:13556082123如有需求请联系我:13556082123如有需求请联系我:13556082123";
        String reg="1[34578]\\d{9}";
        str = str.replaceAll(reg,"********");
        System.out.println(str);
    }

    /*
       替换
     */
    public static void replaceTest2(){
        String str = "我我我要要要做做做项项项项项项项项项目目";
        //还原结巴的话---->我要做项目 把重叠词替换成单个单词。
        String reg="(.)\\1+";
        str = str.replaceAll(reg, "$1");
        //如果需要在replaceAll方法正则的外部引用组的内容,那么是使用"$组号"
        System.out.println(str);
    }


}


