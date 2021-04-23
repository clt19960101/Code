package LeetCode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ��������Ӽ�
 * @Description 368
 * @Author Langtao
 * @Date 2021/4/23 22:12
 * @Version V1.0
 */

public class ��������Ӽ� {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        //dp[i]��ʾ����nums[i]����󳤶ȵ������Ӽ���С
        int[] dp = new int[len];
        //��������Ӽ�����һ�����������Լ�
        Arrays.fill(dp, 1);
        //��󳤶�
        int maxSize = 1;
        //������Ӽ����һ��Ԫ�أ��������DP����ʱ�õ�
        int maxVal = nums[0];
        //nums	2	4	7	8	9	12	16	20
        //dp	1	2	1	3	1	3	4	3
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (maxSize == 1) {
            res.add(nums[0]);
            return res;
        }
        //1.�������dp����ֱ���ҵ�dp[i]=maxSize Ϊֹ
        //2.��maxSize-1,�����ҵ�dp[i]=maxSize,�����ж��,��������maxVal%num[i]==0
        //3.ֱ�� maxSize ��ֵ��� 0
        for (int i = len - 1; i >= 0 && maxSize > 0; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                res.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }
        return res;
    }
}
