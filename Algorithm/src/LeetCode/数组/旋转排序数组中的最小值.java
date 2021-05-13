package LeetCode.数组;

/**
 * @ClassName 旋转排序数组中的最小值
 * @Author Chen Langtao
 * @Date 2021/4/9 23:46
 * @Description 153
 * @Version 1.0
 */
public class 旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        //当left==right时即找到答案
        while (left < right) {
            int mid = left + (right - left) / 2;
            //mid右边一定是有序的，最小值一定是mid右侧的元素
            if (nums[mid] < nums[right]) {
                //最小值可能是nums[mid]
                right = mid;

            }
            //当数组允许有重复值时，当nums[mid] == nums[right],right--;
            else if (nums[mid] == nums[right]) {
                right--;
            }
            //当数组不允许有重复值时，当left==right时即已跳出循环，不存在nums[mid]==nums[right]的情况
            //mid左边数组一定是有序的且都不可能是目标值
            else {
                //最小值不可能是nums[mid]
                left = mid + 1;

            }
        }
        return nums[left];

    }
}
