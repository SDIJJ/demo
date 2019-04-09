package test;

import java.util.Date;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/1/1 10:17
 * @version: v1.0.0
 */
public class BaseGenerator<T> implements Generator<T> {
    private Class<T> type;

    public BaseGenerator(Class<T> type) {
        this.type = type;
    }


    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> BaseGenerator<T> getGenerator(Class<T> type) {
        return new BaseGenerator<T>(type);
    }


    public static void main(String[] args) throws InterruptedException {
        BaseGenerator<Date> baseGenerator = getGenerator(Date.class);
        System.out.println(baseGenerator.next());
        Thread.currentThread().sleep(1000);
        System.out.println(baseGenerator.next());
        System.out.println(baseGenerator.next());
        System.out.println(baseGenerator.next());
        System.out.println(baseGenerator.next());
    }
}

interface Generator<T> {
    T next();
}
