package Arrays.DoublePointer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @ClassName FindCombination
 * @Description 有序的整数数组[2, 3, 5, 7, 9, 10, 11, 12, 13, 14]，寻找满足[]+[]=K条件的值。如果 K=12，则输出(2,10)(3,9)(5,7)组合的对，要求时间和空间复杂度尽可能的低
 * @Author Langtao
 * @Date 2021/1/2 12:56
 * @Version V1.0
 *
 */

public class FindCombination {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5,6,7, 9, 10, 11, 12, 13, 14};
        int k = 12;
        //1.双指针:针对排好序的数组
        doublePointer(nums, k);
        //2.hashmap:适用于全部场景
        hashMapMethod(nums, k);

    }

    private static void hashMapMethod(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(k-num)) {
                System.out.println("(" + String.valueOf(k-num)+ "," + map.get(k-num) + ")");
            }
            map.put(num, k-num);
        }
    }

    private static void doublePointer(int[] nums, int k) {

        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            if (nums[left] + nums[right] == k) {
                System.out.println("("+nums[left++]+","+nums[right]+")");
            } else if (nums[left] + nums[right] > k) {
                right--;
            } else {
                left++;
            }
        }
    }
}