package ioandnio;

import org.junit.Test;

import java.io.*;

/**
 * 测试使用字节流出现的乱码情况
 * 单纯使用字节流作文件的拷贝是绝对不会出现乱码问题的,
 * 真正会出现乱码问题的场景是使用字节流读取一部分文件后转成new String()显示给前端!!!
 */
public class TestLuanMa {

    /**
     * 使用FileInputStream,并自己包装byte数组当做缓存
     */
    @Test
    public void test01() {
        String sourceFile="F:/a.avi";
        String targetFile="F:/b.avi";
        try(
                InputStream is = new FileInputStream(sourceFile);
                OutputStream os = new FileOutputStream(targetFile)
        ) {
            byte[] buf = new byte[1024];
            int size = -1;
            long startTime = System.currentTimeMillis();
            while ( (size = is.read(buf)) != -1) { //从磁盘中读1024个字节
               // System.out.println(size);//1024 755
                os.write(buf, 0, size);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("cost:"+(endTime-startTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Buffer默认缓冲区的大小是8192字节,每次都会将8192个字节读入缓存
     */
    @Test
    public void test02() {
        String sourceFile="F:/a.avi";
        String targetFile="F:/b.avi";
        try(
                InputStream is = new BufferedInputStream(new FileInputStream(sourceFile));
                OutputStream os = new BufferedOutputStream(new FileOutputStream(targetFile));
        ) {
            byte[] buf = new byte[1024];
            int size = -1;
            long startTime = System.currentTimeMillis();
            while ( (size = is.read(buf)) != -1) { //从缓冲区读1024个字节
                os.write(buf, 0, size);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("cost:"+(endTime-startTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 字符流copy视频文件  有问题
     * 如果是文本数据建议使用字符流 如果非文本数据建议使用字节流
     */
    @Test
    public void test03() {
        String sourceFile="F:/a.avi";
        String targetFile="F:/b.avi";
        try(
                BufferedReader br = new BufferedReader (new FileReader(sourceFile));
                BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile));
        ) {
            int content = -1;
            long startTime = System.currentTimeMillis();
            while ( (content=br.read()) != -1) { //从缓冲区读1024个字节
                bw.write(content);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("cost:"+(endTime-startTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
