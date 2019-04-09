package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 测试lambda遍历集合
 * @author: Arnold
 * @since: 2019/3/20 20:42
 * @version: v1.0.0
 */
public class LambdaTest {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("111","一一一");
        map.put("222","二二二");
        map.put("333","三三三");
        map.put("444","四四四");
        map.forEach((k,v)->{
            System.out.println(k+"->>"+v);
        });




    }
}
