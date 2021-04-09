package LeetCode.数组;

/**
 * @ClassName 搜索旋转排序数组I
 * @Author Chen Langtao
 * @Date 2021/4/8 12:27
 * @Description 33
 * @Version 1.0
 */
public class 搜索旋转排序数组I {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left=0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left+(right-left)>>2;
            if (nums[mid] == target) {
                return 0;
            }
            //【0,mid-1] mid [mid+1,right] 其中一个一定是有序得,可以使用二分法进行查找
            //如何判断数组有序：nums[mid]与左右端点值进行比较
            //左边数组有序
            if (nums[0] <= nums[mid]) {
                //target处于有序数组中
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
            //右边数组有序
            else {
                //target处于有序数组中
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
