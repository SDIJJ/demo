package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:线程池
 * @author: Arnold
 * @since: 2019/3/15 12:22
 * @version: v1.0.0
 */
public class PoolTest {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(121);
        for (int i = 0; i <9900; i++)
        pool.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "  " + i);

                }
            }
        });
    }
}
