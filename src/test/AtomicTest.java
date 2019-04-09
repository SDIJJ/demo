package test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description: Atomic 测试
 * @author: Arnold
 * @since: 2019/3/20 20:13
 * @version: v1.0.0
 */
public class AtomicTest {
    public static AtomicInteger integer = new AtomicInteger(0);
    public static int a=0;
    AtomicReference<String> str=new AtomicReference<>();


    public static void main(String[] args) {

     /*   new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();


                while (integer.intValue() < 10000000) {
                    integer.getAndAdd(1);
                }
                long end = System.currentTimeMillis();
                System.out.println(end - start);
            }
        }).start();  */
     new Thread(new Runnable() {
            @Override
            public synchronized   void run() {
                long start = System.currentTimeMillis();


                while (a < 10000000) {
                    a++;
                }
                long end = System.currentTimeMillis();
                System.out.println(end - start);
            }
        }).start();
    }
}
