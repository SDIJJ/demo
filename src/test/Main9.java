package test;

import java.util.Scanner;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/3/30 20:01
 * @version: v1.0.0
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n = in.nextInt();
        int ans = 0;
        while(n > 0) {
            ans += n&1;
            n /= 2;
        }
        System.out.println(ans);
    }

}
