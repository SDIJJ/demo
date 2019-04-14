package gc;

import java.lang.ref.ReferenceQueue;

/**
 * @Description: 测试finalize
 * @author: Arnold
 * @since: 2019/4/14 14:10
 * @version: v1.0.0
 */
public class Finalliation {
    public static Finalliation f;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("执行Finalize...");
        f = this;
    }

    public static void main(String[] args) {
        Finalliation fin = new Finalliation();
        System.out.println("第一次： " + fin);
        fin = null;
        System.gc();

        try {
            Thread.currentThread().sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("第二次： " + fin);
        System.out.println(fin.f);

    }
}
