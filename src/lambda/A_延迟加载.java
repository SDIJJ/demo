package lambda;

/**
 * @Description: 测试lambda表达式的延迟加载
 * @author: Arnold
 * @since: 2019/4/15 10:32
 * @version: v1.0.0
 */
public class A_延迟加载 {
    private static void log(int level, MessageBuilder builder) {
        if (level == 1)
            System.out.println(builder.buildMessage());
    }

    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";
        log(1, () -> msgA + msgB + msgC);
        log(2, () -> {
            System.out.println("Lambda执行！");
            return msgA + msgB + msgC;
        });
    }
}

@FunctionalInterface
interface MessageBuilder {
    String buildMessage();
}
