package ioandnio;

import org.junit.Test;

import java.io.File;
import java.util.regex.Matcher;

/**
 * @Auther ljn
 * @Date 2020/3/3
 */
public class TestFile {

    /*
      File.separator:在 UNIX 系统上，此字段的值为 '/'；在 Microsoft Windows 系统上，它为 '\'。
      因为替换时使用了正则表达式，而'\'是正则中的关键字，替换会造成混淆。
      解决办法：使用Matcher.quoteReplacement(sep)转义。
     */
    @Test
    public void test01(){
        System.out.println(File.separator);// ->"\";
        String packageName = "com.xxx.model";
        String path = packageName.replaceAll("\\.",File.separator);
       // String path = packageName.replaceAll("\\.",Matcher.quoteReplacement(File.separator));
        System.out.println(path);
    }

    @Test
    public void test02(){
        File file = new File("f:/a/b/");//这是一个目录的地址
        if(!file.exists()){
            file.mkdirs();//创建多级目录
        }
    }


}
