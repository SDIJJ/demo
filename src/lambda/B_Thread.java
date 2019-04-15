package lambda;

/**
 * @Description: 测试函数式参数
 * @author: Arnold
 * @since: 2019/4/15 10:43
 * @version: v1.0.0
 */
public class B_Thread {
    private static void startThread(Runnable run) {
        new Thread(run).start();
    }

    public static void main(String[] args) {
        startThread(() -> {
            System.out.println(Thread.currentThread().getName() + " 123");
        });
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "   456")).start();
    }
}
