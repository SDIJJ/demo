package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 测试线程池
 * @author: Arnold
 * @since: 2019/3/15 15:10
 * @version: v1.0.0
 */
public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        pool.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.shutdownNow();
        System.out.println("Main run");
    }
}
