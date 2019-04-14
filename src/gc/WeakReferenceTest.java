package gc;

import java.lang.ref.WeakReference;

/**
 * @Description: 弱引用测试
 * @author: Arnold
 * @since: 2019/4/14 16:31
 * @version: v1.0.0
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        String str=new String("tongtong");
        WeakReference<String> stringWeakReference = new WeakReference<>(str);
        System.out.println(stringWeakReference.get());
        System.gc();
        System.out.println(stringWeakReference.get());
    }
}
