package test;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/3/23 18:30
 * @version: v1.0.0
 */
public class Main3 {
    public static void main(String[] args) {

        int result=0;
        int max=0;
        for (int i = 1; i <=1000000 ; i++) {
            int count=0;
            int n=i;
            while(n!=1){
                if(n%2==0)
                    n/=2;
                else
                    n=3*n+1;
                count++;
//                System.out.println("n    "+n);

            }
            if(count>max){
                result=i;
                max=count;
            }
            System.out.println(result);
        }
        System.out.println(result);
    }
}
