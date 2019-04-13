package classLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/**
 * @Description: 测试自定义累加载器
 * @author: Arnold
 * @since: 2019/4/13 15:43
 * @version: v1.0.0
 */
public class MyClassLoader extends ClassLoader {
    private String classLoaderName;
    private String path;

    public MyClassLoader(String path, String classLoaderName) {
        this.classLoaderName = classLoaderName;
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        byte[] buffer = readClass(name);
        byte[] buffer = new byte[0];
        try {
            buffer = readClassForNio(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.defineClass(name, buffer, 0, buffer.length);
    }

    private byte[] readClass(String name) {
        String p = path + "/" + name + ".class";
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             FileInputStream in = new FileInputStream(new File(p))) {
            int i = 0;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
            return out.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] readClassForNio(String name) throws Exception {
        String p = path + "/" + name + ".class";
        FileChannel inChannel = new FileInputStream(new File(p)).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[] arr = new byte[inChannel.read(buffer)];
        byte[] array = buffer.array();
        for (int i = 0; i < arr.length; i++)
            arr[i] = array[i];
        return arr;
    }
}
