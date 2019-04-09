package test;


/**
 * @Description:
 * @author: Arnold
 * @since: 2019/3/30 20:30
 * @version: v1.0.0
 */

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Main10
{
    public static void main(String[] args) {
     /*   long start=System.currentTimeMillis();
        System.out.println(1<<30);
        System.out.println(System.currentTimeMillis()-start);
        System.out.println(Math.pow(2,30));
        System.out.println(System.currentTimeMillis()-start);*/

        ConcurrentHashMap map=new ConcurrentHashMap();
        map.put(11,99);

        HashMap hashMap=new HashMap();
        hashMap.put(null, "tongtong");
        System.out.println(hashMap.get(null));

    }
}



