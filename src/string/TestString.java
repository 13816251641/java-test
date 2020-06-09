package string;

import org.junit.Test;

/**
 * @Auther lujieni
 * @Date 2020/4/10
 */
public class TestString {

    @Test
    public void test(){
        String a = String.format("%s---%s", "a", null);
        System.out.println(a);
    }

    @Test
    public void test2(){
        boolean contains = "510000-510400-510403".contains("510000-510400-");
        System.out.println(contains);
    }

    @Test
    public void test3(){
        String n=null;
        String result = "122222-222221-null".replace("null", "");
        System.out.println(""+n);
    }

    @Test
    public void test4(){
        String str1="droid";
        String str2="droid";
        System.out.println(str1 == str2);
        String str3 = new String("droid");
        System.out.println(str1==str3);

        /*
            调用intern后，首先检查字符串常量池中是否有该对象的引用，
            如果存在,则将这个引用返回给变量,否则将引用加入并返回给变量。
         */
        String str4=str3.intern();

        System.out.println(str1 == str4);

    }

    @Test
    public void test5(){
        String str1="ab";
        /*
          由于+左右都是显式的字符常量,所以加号操作符没有申请新的String变量,
          而是指向常量池中原有的”ab”. 如果常量池中并没有”ab”, 那么加号操作符就会在常量池中添加”ab”
         */
        String str2="a"+"b";
        System.out.println(str1 == str2);
    }

    static String  base = "string";


    @Test
    public void test6(){
        String str = base+base;//str相当于new出来的
        System.out.println(str.intern() == "stringstring");
    }
}
