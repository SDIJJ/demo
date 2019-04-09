package test;

import java.util.concurrent.*;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/3/19 20:02
 * @version: v1.0.0
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<String> submit = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("当前线程的名字是:"+ Thread.currentThread().getName());
                Thread.sleep(10000);
                return "Test  is  successful!!!";
            }
        });
        if(!submit.isDone()){
            System.out.println(submit.get());
        }
        service.shutdown();
    }
}
