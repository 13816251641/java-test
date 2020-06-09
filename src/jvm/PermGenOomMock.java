package jvm;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther lujieni
 * @Date 2020/6/9
 */
public class PermGenOomMock {

    static String base = "string";

    /**
     *  JDK 1.7 和 1.8 将字符串常量由永久代转移到堆中
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i=0;i< Integer.MAX_VALUE;i++){
            String str = base + base;
            base = str;
            list.add(str);
        }
    }
}
