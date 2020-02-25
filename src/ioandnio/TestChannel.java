package ioandnio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Auther ljn
 * @Date 2020/2/25
 */
public class TestChannel {

    @Test
    public void test1() throws Exception {
       /* long start = System.currentTimeMillis();
        try (
                FileInputStream fis = new FileInputStream("F:/a.avi");
                FileOutputStream fos = new FileOutputStream("F:/b.avi");
                FileChannel inChannel = fis.getChannel();
                FileChannel outChannel = fos.getChannel()
        ) {
            long startTime = System.currentTimeMillis();
            //2.分配指定大小的缓冲区
            ByteBuffer buf=ByteBuffer.allocate(8192);

            //3.将通道中的数据存入缓冲区中
            while(inChannel.read(buf)!=-1){
                buf.flip();//切换读取数据的模式
                //4.将缓冲区中的数据写入通道中
                outChannel.write(buf);
                buf.clear();//清空缓冲区
            }
            long endTime = System.currentTimeMillis();
            System.out.println("cost:"+(endTime-startTime));
        }*/

        // TODO Auto-generated method stub
        long startTime=System.currentTimeMillis();
        FileInputStream inFile=new FileInputStream("F:/a.avi");
        FileOutputStream outFile=new FileOutputStream("F:/b.avi");
        FileChannel inchannel = inFile.getChannel();
        FileChannel outchannel = outFile.getChannel();
        long size = inchannel.size();
        inchannel.transferTo(0, size, outchannel);
        long endTime=System.currentTimeMillis();
        System.out.println("nio文件时间--》"+(endTime-startTime));

        inchannel.close();
        outchannel.close();
    }

}
