package lambda;

import java.util.function.Consumer;

/**
 * @Description: <p>
 * 下面的字符串数组当中存有多条信息，请按照格式“ 姓名：XX。性别：XX。”的格式将信息打印出来。要求将打印姓
 * 名的动作作为第一个Consumer 接口的Lambda实例，将打印性别的动作作为第二个Consumer 接口的Lambda实
 * 例，将两个Consumer 接口按照顺序“拼接”到一起。
 * </p>
 * @author: Arnold
 * @since: 2019/4/15 11:16
 * @version: v1.0.0
 */
public class F_DemoConsumer {
    public static void main(String[] args) {
        String[] array = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男"};
        printInfo(s -> System.out.print("姓名：" + s.split(",")[0]),
                s -> System.out.println("。性别：" + s.split(",")[1] + "。"),
                array);
    }

    private static void printInfo(Consumer<String> one, Consumer<String> two, String[] array) {
        for (String info : array) {
            one.andThen(two).accept(info); // 姓名：迪丽热巴。性别：女。
        }
    }
}
