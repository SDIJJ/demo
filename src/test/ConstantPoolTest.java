package test;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/1/13 16:27
 * @version: v1.0.0
 */
public class ConstantPoolTest {
    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "123";

        String s3 = new String("123");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        System.out.println(s1 == s3.intern());
    }
}
