package LeetCode.AC;

/**
 * @ClassName ��ҽ���I
 * @Description 198
 * @Author Langtao
 * @Date 2021/4/15 22:58
 * @Version V1.0
 */

public class ��ҽ���I {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++) {
            //dp[i]��ʾ͵ǰi�������Ľ��
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);

        }
        return dp[nums.length];
    }
}
