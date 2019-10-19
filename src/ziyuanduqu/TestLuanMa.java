package ziyuanduqu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 测试使用字节流出现的乱码情况
 * 单纯使用字节流作文件的拷贝是绝对不会出现乱码问题的,
 * 真正会出现乱码问题的场景是使用字节流读取一部分文件后转成new String()显示给前端!!!
 */
public class TestLuanMa {

    public static void main(String[] args) {
        String sourceFile="D:/IdeaWorkSpace/source.txt";
        String targetFile="D:/IdeaWorkSpace/dest.txt";
        try(
                InputStream is = new FileInputStream(sourceFile);
                OutputStream os = new FileOutputStream(targetFile)
        ) {
            byte[] buf = new byte[1];
            int size = -1;
            while ( (size = is.read(buf)) != -1) {
                os.write(buf, 0, size);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
