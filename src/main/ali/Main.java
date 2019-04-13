package main.ali;

import java.util.Scanner;

/**
 * @Description: 阿里笔试
 * @author: Arnold
 * @since: 2019/4/12 18:46
 * @version: v1.0.0
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/

    static String calculate(int m, int k) {
        long arr[]=new long[m+1];
        long aux[]=new long[m+1];
        arr[1]=2;
        arr[2]=3;
        arr[3]=4;
        for (int i = 4; i <=m ; i++) {
            arr[i]=arr[i-2]+arr[i-3];
        }
        for (int i = 1; i <=m ; i++) {
            aux[i]=num(arr[i]);
        }

        System.out.println(arr[m]);
        Arrays.sort(aux);

        long temp=num(aux[m-k+1]);
        for (int i = 1; i <=m ; i++) {
            if(arr[i]==temp)
                System.out.println(i);
        }


        return "we";



    }

    private static  long num(long k) {
        long sum=0;
        while(k>0){
            sum=sum*10+k%10;
            k=k/10;
        }
        return sum;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);;
        System.out.println(calculate(m, k));

    }
}