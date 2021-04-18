package LeetCode.AC;

/**
 * @ClassName ��ҽ���II
 * @Description 213
 * @Author Langtao
 * @Date 2021/4/15 23:08
 * @Version V1.0
 */

public class ��ҽ���II {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            /**
             * ��β��ܱ�֤��һ�䷿�ݺ����һ�䷿�ݲ�ͬʱ͵���أ�
             * ���͵���˵�һ�䷿�ݣ�����͵�����һ�䷿�ݣ����͵�Է��ݵķ�Χ�ǵ�һ�䷿�ݵ����ڶ��䷿�ݣ�
             * ���͵�������һ�䷿�ݣ�����͵�Ե�һ�䷿�ݣ����͵�Է��ݵķ�Χ�ǵڶ��䷿�ݵ����һ�䷿��
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
