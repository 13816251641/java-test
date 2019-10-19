package zhengzei;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
   网络爬虫
  总的来说，String.matches(regex)，Pattern.matches(regex, str)，Matcher.matches()都是全局匹配的，
  相当于"^regex$"的正则匹配结果。如果不想使用全局匹配则可以使用Matcher.find()方法进行部分查找。
 */
public class WangLuoPaChong {

    // .com .cn  .com.cn  .net
    public static void main(String[] args) {
        String content="有事没事联系:1122423@163.com 有事没事联系:1122423@qq.com 有事没事联系:1122423@qq.com" +
                        "有事没事联系:1122423@qq.com.cn 有事没事联系:1122423@163.com 有事没事联系:1122423@qq.net";
        String reg="[a-zA-Z1-9]\\w{5,17}@[a-zA-Z0-9]{2,}(\\.(com|cn|net)){1,2}";
        // (com|cn|net) 代表或的关系  (\\.(com|cn|net)){1,2}代表 (\\.(com|cn|net))出现1到2次
        Pattern pattern = Pattern.compile(reg);
        Matcher m = pattern.matcher(content);
        while (m.find()){
            System.out.println(m.group());
        }
    }

}
