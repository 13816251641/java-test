package zhengzei;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
   正则对象
   查找:

   指定为字符串的正则表达式必须首先被编译为此类的实例。然后,可将得到的正则
   对象匹配任意的字符串用于创建Matcher对象,执行匹配所涉及的所有状态都驻留
   在匹配容器中,所以多个匹配器可以共享同一模式。因此,典型的调用顺序是
      Pattern p = Pattern.compile("\\d{9}");
      Matcher m = p.matcher("aaaaa1233);
      boolean b = m.matches();

   查找需要使用的对象:
      1. Pattern(正则对象)
      2. Matcher(匹配器对象)

   匹配器要使用到的方法:
      1.find() 通知匹配器去匹配字符串,查找符合规则的字符串。如果能查找到符合规则的
      字符串,则返回true,否则返回false。
      2.group() 获取符合规则的子串

   注意:使用group方法的时一定要先调用find方法

   注意: 使用group方法的时候一定要先调用find方法让匹配器去查找符合规则的字符串,否则报错。
 */
public class ZhengZeDuiXiang {

    public static void main(String[] args) {
        test1();

    }

    /*
        找出三个字母组成的单词
     */
    public static void test1(){
        String content = "da jia de jia qi wan bi liao hai hai xin ma aaaaa";
        String reg="\\b[a-zA-Z]{3}\\b";
        //使用了单词边界符
        Pattern p = Pattern.compile(reg);
        //先把要字符串的正则编译成Pattern对象。
        Matcher m = p.matcher(content);
        //使用正则对象匹配字符串用于产生一个Matcher对象

        while(m.find()){
            System.out.println(m.group());
        }

    }


}
