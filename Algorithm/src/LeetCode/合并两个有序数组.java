package LeetCode;

import java.util.Arrays;

/**
 * @ClassName 合并两个有序数组
 * @Description https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetcode/
 * @Author Langtao
 * @Date 2021/3/21 12:28
 * @Version V1.0
 */

public class 合并两个有序数组 {
    public static void main(String[] args) {
        int[] num1 = new int[]{1, 3, 4, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;
//        mergeMethod_1(num1, m, num2, n);
        //双指针从前往后
        merge1(num1, m, num2, n);

    }

    private static int[] mergeMethod_1(int[] num1, int m, int[] num2, int n) {
        System.arraycopy(num2, 0, num1, m, n);
        Arrays.sort(num1);
        return num1;
    }

    private static int[] merge1(int[] num1, int m, int[] num2, int n) {
        //由于 nums1 是用于输出的数组，需要将nums1中的前m个元素放在其他地方，也就需要 O(m) 的空间复杂度
        int[] copy_num1 = new int[m];
        System.arraycopy(num1, 0, copy_num1, 0, m);
        //copy_num1的指针
        int p1 = 0;
        //num2的指针
        int p2 = 0;
        //num1的指针
        int p0 = 0;
        while (p1 < m && p2 < n) {
            num1[p0++] = copy_num1[p1] < num2[p2] ? copy_num1[p1++] : num2[p2++];
        }
        if (p1 < m) {
            System.arraycopy(copy_num1, p1, num1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(num2, p2, num1, p1 + p2, m + n - p1 - p2);
        }
        return num1;
    }


}
