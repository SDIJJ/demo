package test;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/4/14 9:49
 * @version: v1.0.0
 */
public class Hello{
    public static int add(int a,int b){
        int c=0;
        c=a+b;
        return c;
    }

    public static int recur(int i){

        recur(i);
        return i;
    }

    public static void main(String args[]){
        while(true){
            new Thread(()->{
                while (true){}
            }).start();
        }
    }
}