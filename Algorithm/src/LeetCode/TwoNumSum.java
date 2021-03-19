package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TwoNumSum
 * @Description 两数之和
 * @Author Langtao
 * @Date 2021/1/27 23:45
 * @Version V1.0
 */

public class TwoNumSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> integerHashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (integerHashMap.containsKey(target - nums[i])) {
                return new int[]{integerHashMap.get(target - nums[i]), i};
            }
            integerHashMap.put(nums[i], i);
        }
        return new int[0];

    }
}
