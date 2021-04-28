package LeetCode.DP;

/**
 * @ClassName ����ܺ�IV
 * @Description 377
 * @Author Langtao
 * @Date 2021/4/24 23:22
 * @Version V1.0
 */

public class ����ܺ�IV {
    public int combinationSum4(int[] nums, int target) {
        //dp[i]��ʾtargetΪiʱ���������
        int[] dp = new int[target + 1];
        //�������г�ȡ�κ�Ԫ����ϳ�0�ķ�����
        dp[0] = 1;
        //Ϊ��֤˳��,���ѭ���Ǵ�1��target��ֵ���ڲ�ѭ���Ǳ�������nums��ֵ��
        // �����ÿ��ֵ�������������е������
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
