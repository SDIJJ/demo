package test;

import java.util.Arrays;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/3/29 16:07
 * @version: v1.0.0
 */
public class Main7 {
    {
        System.out.println("父类块");
    }
    public Main7(){
        System.out.println("父类构造器");
    }

    public static void main(String[] args) {
        new Main7_1();
        Arrays.asList(new int[]{1,2,3}).stream().forEach(System.out::println);
    }
}

class Main7_1 extends Main7{
    {
        System.out.println("子类块");
    }
    public Main7_1(){
        System.out.println("子父类构造器");
    }
}

abstract  class AbstractClass{
    public AbstractClass(){
        
    }
}
