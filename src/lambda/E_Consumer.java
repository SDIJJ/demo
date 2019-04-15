package lambda;

import java.util.function.Consumer;

/**
 * @Description: 测试Consumer
 * @author: Arnold
 * @since: 2019/4/15 11:04
 * @version: v1.0.0
 */
public class E_Consumer {
    private static void consumeString(Consumer<String> consumer) {
        consumer.accept("tongtong");
    }

    private static void consumeString2(Consumer<String> one, Consumer<String> two) {
        one.andThen(two).accept("tongtong");
    }

    public static void main(String[] args) {
        consumeString(s -> System.out.println(s));
        consumeString2(s -> System.out.println(s.toLowerCase()), s -> System.out.println(s.toUpperCase()));
    }
}
