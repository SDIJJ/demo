package test;

import java.math.BigInteger;
import java.util.Formatter;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/1/13 12:07
 * @version: v1.0.0
 */
public class FormatterTest {
    public static void main(String[] args) {
        int a=5;
        double d=123.123;
        BigInteger bigInteger=new BigInteger("100000");
        Formatter formatter=new Formatter(System.out);
        formatter.format("整数型: %d\n" ,a);
        formatter.format( "Unicoode字符  %c\n" ,a);
        formatter.format(" Boolean型 %b\n" ,a);
        formatter.format("浮点型 %f\n" ,3.4);
        formatter.format("科学计数法 %e\n" ,d);
        formatter.format("十六进制整形 %x\n" ,a);
        formatter.format("散列码 %h\n" ,a);
    }
}
