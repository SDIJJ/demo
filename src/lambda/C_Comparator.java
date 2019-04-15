package lambda;

import java.util.Arrays;

/**
 * @Description: 测试返回值是函数式接口的Comparator
 * @author: Arnold
 * @since: 2019/4/15 10:47
 * @version: v1.0.0
 */
public class C_Comparator {
    public static void main(String[] args) {
        String[] arr = {"abc", "ab", "abcd", "a"};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        System.out.println(Arrays.toString(arr));
    }
}
