package test;

import java.util.Scanner;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/3/30 18:59
 * @version: v1.0.0
 */
public class Main8 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.equals("None")) {
            System.out.println("True");
            return;
        }
        final int MAX = -10000;
        String arr[] = str.split(",");
        int arrInt[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("None"))
                arrInt[i] = MAX;
            else
                arrInt[i] = Integer.valueOf(arr[i]);
        }
      /*  for (int i = 0; i < arr.length; i++) {
          *//*  if (2 * i + 2 <= arr.length) {
                if(arrInt[i]==MAX)
                    continue;
                if (arrInt[i] >= arrInt[2 * i + 1] && arrInt[i] < arrInt[2 * i + 2])
                    continue;
                else {
                    System.out.println("False");
                    return;

                }
            }*//*
        }*/
        for(int i=arr.length-1;i>=0;i--){

        }
        System.out.println("True");
    }
}
