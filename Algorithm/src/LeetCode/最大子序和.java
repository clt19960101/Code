package LeetCode;

/**
 * @ClassName 最大子序和
 * @Description TODO
 * @Author Langtao
 * @Date 2021/3/22 21:27
 * @Version V1.0
 */

public class 最大子序和 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));

    }

    private static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;

    }
}
