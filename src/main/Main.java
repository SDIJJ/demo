package main;


import java.util.Scanner;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/4/5 19:17
 * @version: v1.0.0
 */
public class Main {
    public static int n;
    public static long ans=Long.MAX_VALUE;
    public static long a []=new  long[105];
    public static long b []=new  long[105];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n=in.nextInt();
        for (int i = 0; i <n ; i++) {
               a[i]=in.nextLong();
        }
        for (int i = 0; i <n ; i++) {
            b[i]=in.nextLong();
        }
        dfs(0,0,0);
        System.out.println(ans);
    }
    public static void dfs(long x ,long y,long z){
        if(x==n){
            ans=ans>z?z:ans;
            return;
        }
        if(y<a[(int)x]){
            dfs(x+1,y+a[(int)x],z+b[(int)x]);
        }
        else{
            dfs(x+1,y+a[(int)x],z+b[(int)x]);
            dfs(x+1,y,z);
        }
    }
}
