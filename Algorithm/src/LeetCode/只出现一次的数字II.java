package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName 只出现一次的数字II
 * @Description 137
 * @Author Langtao
 * @Date 2021/4/30 23:42
 * @Version V1.0
 */

public class 只出现一次的数字II {
    //hash法
    public int singleNumber_Hash(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = nums[0];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ans = entry.getKey();
                break;
            }
        }
        return ans;
    }

    //依次确定每一个二进制位
    //答案的第i位，它可能是0或1，其他数都出现了三次，那么第i位二进制为三个0或三个1
    //无论哪一种都是3的倍数
    public int singleNumber_01(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            //第i位二进制出现次数
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
