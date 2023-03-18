package Arrays.Others;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ClassName 循环有序数组中找到给定数
 * @Description TODO
 * @Author Langtao
 * @Date 2021/3/21 14:16
 * @Version V1.0
 */

public class 循环有序数组中找到给定数 {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 3, 4, 5, 5};
        int num = findNum(arr, 6);
        System.out.println(num);
    }

    private static int findNum(int[] arr, int target) {
        if (arr.length < 1) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == target) {
                return mid;
            }
            //转折点在右边
            if (arr[left] < arr[mid]) {
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }else{
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }
        return -1;

    }
}
