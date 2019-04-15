package lambda;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * @Description: 测试Supplier->提供者，只有返回值
 * @author: Arnold
 * @since: 2019/4/15 10:52
 * @version: v1.0.0
 */
public class D_Supplier {
    private static String getString(Supplier<String> stringSupplier) {
        return stringSupplier.get();
    }

    /**
     * 求数组的最大值
     *
     * @param integerSupplier
     * @return
     */
    private static int getMax(Supplier<Integer> integerSupplier) {
        return integerSupplier.get();
    }

    public static void main(String[] args) {
        System.out.println(getString(() -> "tongtong"));
        System.out.println();
        int[] arr = {1, 2, 3, 4, 5, 6, 0, 3, 3};
        System.out.println(getMax(() -> Arrays.stream(arr).max().getAsInt()));
        System.out.println(Arrays.stream(arr).max().getAsInt());
    }
}
