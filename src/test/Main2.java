package test;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/3/11 20:15
 * @version: v1.0.0
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2
{
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n = in.nextInt();
        int sum[] = new int[n+1];
        sum[0] = 0;
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            sum[i] = sum[i-1]+in.nextInt();
            if(map.get(sum[i]) != null) {
                    ans=Math.max(ans,i-map.get(sum[i]));
            }else {
                map.put(sum[i], i);
            }
        }
        System.out.println(ans);
    }
}

