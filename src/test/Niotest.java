package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description: NIO 测试
 * @author: Arnold
 * @since: 2019/3/3 17:04
 * @version: v1.0.0
 */
public class Niotest {

    public static void copy(String src, String des) throws Exception {
        FileInputStream fis = new FileInputStream(new File(src));
        FileOutputStream fos = new FileOutputStream(new File(des));

        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            int eof = inChannel.read(buffer);
            if (eof == -1)
                break;
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }

        outChannel.close();
        inChannel.close();
        fis.close();
        fos.close();

    }

    public static void main(String[] args) throws Exception {
        copy("C:/Users/JIA/Desktop/深入理解Java虚拟机.pdf", "C:\\Users\\JIA\\Desktop\\aaa.java");
    }
}


class test{
    public void copy(String src,String target) throws Exception{
        FileInputStream fis=new FileInputStream(new File(src));
        FileOutputStream fos=new FileOutputStream(new File(target));

        FileChannel fileChannel1=fis.getChannel();
        FileChannel fileChannel2=fos.getChannel();

        ByteBuffer byteBuffer= ByteBuffer.allocate(1024);


        while(true){
            int  eof=fileChannel1.read(byteBuffer);
            if(eof==-1)
                break;
            byteBuffer.flip();
            fileChannel2.write(byteBuffer);
            byteBuffer.clear();
        }

        //关流;
    }


}
