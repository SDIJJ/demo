package test;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/1/12 20:37
 * @version: v1.0.0
 */
public class StringTest {

    public static void main(String[] args) {
        int x=12;
        double y=3.444;
        System.out.format("Row 1: [%d %f]\n",x,y);

        String str=String.format("Row 1: [%d %f]\n",x,y);
        System.out.println(str);
    }
}
