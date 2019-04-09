package test;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/3/11 19:21
 * @version: v1.0.0
 */

public class Main {


    public static int fun(int[] a) {
        if (a.length < 3) {
            return 0;
        }
        int[] l = new int[a.length];
        int[] r = new int[a.length];
        int result = 0;
        l[0] = 0;
        r[a.length - 1] = 0;
        for (int i = 1; i <= a.length - 2; i++) {
            l[i] = Math.max(l[i - 1], a[i - 1]);
            r[a.length - 1 - i] = Math.max(r[a.length - i], a[a.length - i]);
        }
        for (int i = 1; i <= a.length - 2; i++) {
            if (l[i] > a[i] && r[i] > a[i]) {
                result += Math.min(l[i], r[i]) - a[i];
            }
        }
        return result;

    }

    public static void main(String[] args) {

        Arrays.stream(args).forEach(System.out::println);
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) 
            a[i] = in.nextInt();
       
        System.out.println(fun(a));
    }
}

