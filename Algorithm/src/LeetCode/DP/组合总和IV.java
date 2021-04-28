package LeetCode.DP;

/**
 * @ClassName 组合总和IV
 * @Description 377
 * @Author Langtao
 * @Date 2021/4/24 23:22
 * @Version V1.0
 */

public class 组合总和IV {
    public int combinationSum4(int[] nums, int target) {
        //dp[i]表示target为i时的组合总数
        int[] dp = new int[target + 1];
        //从数组中抽取任何元素组合成0的方案数
        dp[0] = 1;
        //为保证顺序,外层循环是从1到target的值，内层循环是遍历数组nums的值。
        // 数组的每个值都可能排在序列的最后面
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
