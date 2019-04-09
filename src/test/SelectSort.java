package test;

import java.util.Arrays;


/**
 * @Description:
 * @author: Arnold
 * @since: 2019/4/6 8:17
 * @version: v1.0.0
 */
public class SelectSort {
    public static void select(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            swap(arr,i,minIndex);
        }
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr []=new int[]{1,3,4,2,5,6,1,7,2};
        SelectSort.select(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
