package LeetCode.AC;

/**
 * @ClassName 打家劫舍II
 * @Description 213
 * @Author Langtao
 * @Date 2021/4/15 23:08
 * @Version V1.0
 */

public class 打家劫舍II {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            /**
             * 如何才能保证第一间房屋和最后一间房屋不同时偷窃呢？
             * 如果偷窃了第一间房屋，则不能偷窃最后一间房屋，因此偷窃房屋的范围是第一间房屋到最后第二间房屋；
             * 如果偷窃了最后一间房屋，则不能偷窃第一间房屋，因此偷窃房屋的范围是第二间房屋到最后一间房屋
             */
            return Math.max(robRange(nums, 1, nums.length - 1),
                    robRange(nums, 2, nums.length));
        }

    }

    public int robRange(int[] nums, int start, int end) {
        int[] dp = new int[nums.length + 1];
        dp[start] = nums[start-1];
        for (int i = start+1; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[end];
    }
}
