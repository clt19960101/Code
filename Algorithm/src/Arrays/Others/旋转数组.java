package Arrays.Others;

import java.util.HashMap;

/**
 * @ClassName 旋转数组
 * @Author Chen Langtao
 * @Date 2021/11/2 20:23
 * @Description TODO
 * @Version 1.0
 */
public class 旋转数组 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 2;
//        rotate_1(nums, k);
        rotate_2(nums, k);

    }

    public static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    /**
     * 太笨，不太理解，特别是循环次数
     *
     * @param nums
     * @param k
     */
    public static void rotate_1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int i = 0; i < count; i++) {
            int current = i;
            int prev = nums[i];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (i != current);
        }
    }

    /**
     * 翻转点：[0,k%n-1]-[k%n,n-1]
     *
     * @param nums
     * @param k
     *
     */
    public static void rotate_2(int[] nums, int k) {
        int index = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, index - 1);
        reverse(nums, index, nums.length - 1);

    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];

            nums[end] = temp;
            start++;
            end--;
        }


    }

}
