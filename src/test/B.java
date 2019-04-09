package test;


/*
import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(new Solution().getResult(scanner.nextLine()));
//
//        String s;
//        StringBuilder sb;
//        StringBuffer sb1;


    }

    public String getResult(String str) {
        int start = 0, end = 0;
        for (int i = 0; i < str.length(); i++) {
            int len1 = extend(str, i, i);
            int len2 = extend(str, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end + 1);

    }

    private int extend(String s, int L, int R) {
        int l = L;
        int r = R;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

}

interface Interface{
    default void test(){
        System.out.println("this is interface default method!!!");
    }

}
*/


class A {
    private static A a=new A();
    static{
        System.out.print("static");
    }
    public A(){
        System.out.print("A ");
    }
}

public class B extends A{
    public B(){
        System.out.print("B");
    }
    public static void main(String[] args) {
//        B b=new B();
    }
}
