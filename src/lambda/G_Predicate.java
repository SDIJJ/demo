package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Description: 测试 Predicate
 * @author: Arnold
 * @since: 2019/4/15 11:20
 * @version: v1.0.0
 */
public class G_Predicate {
    private static void predicateLength(Predicate<String> predicate) {
        System.out.println("this is string is long?" + predicate.test("tongtong"));
    }

    /**
     * 要判断一个字符串既要包含大写“H”，又要包含大写“W”
     *
     * @param one
     * @param two
     */
    private static void method(Predicate<String> one, Predicate<String> two) {
        boolean isValid = one.and(two).test("Helloworld");
        System.out.println("字符串符合要求吗：" + isValid);
    }

    private static List<String> predicate(String[] arr, Predicate<String> one, Predicate<String> two) {
        List<String> list = new ArrayList();
        Arrays.stream(arr).forEach(e -> {
            if (one.and(two).test(e))
                list.add(e);

        });
        return list;
    }

    public static void main(String[] args) {
        predicateLength(s -> s.length() > 5);
        method(s -> s.contains("H"), s -> s.contains("W"));

        String[] array = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女"};
        System.out.println(predicate(array, s -> s.split(",")[1].equals("女"), s -> s.split(",")[0].length() == 4));
    }
}
