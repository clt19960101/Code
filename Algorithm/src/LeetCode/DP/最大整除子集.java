package LeetCode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName 最大整除子集
 * @Description 368
 * @Author Langtao
 * @Date 2021/4/23 22:12
 * @Version V1.0
 */

public class 最大整除子集 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        //dp[i]表示包含nums[i]的最大长度的整除子集大小
        int[] dp = new int[len];
        //最大整除子集最少一个，即包含自己
        Arrays.fill(dp, 1);
        //最大长度
        int maxSize = 1;
        //最长整除子集最后一个元素，反向遍历DP数组时用到
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
        //1.倒叙遍历dp数组直到找到dp[i]=maxSize 为止
        //2.将maxSize-1,继续找到dp[i]=maxSize,加入有多个,必须满足maxVal%num[i]==0
        //3.直到 maxSize 的值变成 0
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
