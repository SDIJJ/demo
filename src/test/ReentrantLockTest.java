package test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:  ReentrantLock 公平性测试
 * @author: Arnold
 * @since: 2019/3/20 16:35
 * @version: v1.0.0
 */
public class ReentrantLockTest implements Runnable {
    private static ReentrantLock lock = new ReentrantLock(false);



    @Override
    public void run() {
        for ( ; ;) {
            try {
                lock.lock();

                System.out.println(Thread.currentThread().getName() + "  get lock");
                Thread.sleep(50);

            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockTest test=new ReentrantLockTest();
        new Thread(test).start();
        new Thread(test).start();
    }


}
