package test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 测试线程安全
 * @author: Arnold
 * @since: 2019/3/26 16:48
 * @version: v1.0.0
 */
public class CurrentTest {
    public static AtomicInteger count = new AtomicInteger(0);
    public static volatile int count2 = 0;



    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    count.getAndAdd(1);
                    count2++;
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
//                    count.getAndAdd(1);
                    count2++;
                }
            }
        }).start();
        Thread.sleep(1000);
        System.out.println(count2);
    }
}
