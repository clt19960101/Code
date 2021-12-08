package Arrays.Sort;

import java.util.Collections;

/**
 * @ClassName BubbleSort
 * @Description 冒泡排序
 * @Author Langtao
 * @Date 2021/1/17 18:31
 * @Version V1.0
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {85, 8, 54, 3, 23};
        doBubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    private static void doBubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //0~N-1
        //0~N-2
        //0~N-3
        for (int i = arr.length - 1; i > 0; i--) {
            //相邻之间比较大小并交换
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        arr[i] = arr[i] ^ arr[i1];
        arr[i1] = arr[i] ^ arr[i1];
        arr[i] = arr[i] ^ arr[i1];
//        int temp = arr[i];
//        arr[i] = arr[i1];
//        arr[i1]=temp;
    }
}