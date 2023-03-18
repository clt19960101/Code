package Arrays.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName FindCombinations
 * @Description 给定一个长度n的有序array和一个target值，请找出array中所有可能加在一起等于target值的组合
 * 每个元素只能用一次，有重复，同样的组合只输出一次
 * @Author Langtao
 * @Date 2023/3/18 23:46
 * @Version V1.0
 */

public class FindCombinations {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,2,5};
        int target = 5;
        List<List<Integer>> combinations = findCombinations(nums, target);
        combinations.forEach(src-> src.forEach(System.out::println));
    }

    private static List<List<Integer>> findCombinations(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTrace(nums, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private static void backTrace(int[] nums, int target, int start, ArrayList<Integer> path, List<List<Integer>> res) {
        if (target == 0) {//找到一个组合
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length ; i++) {
            if (nums[i] > target) {//如果当前数大于target直接返回
                break;
            }
            if (i > start && nums[i] == nums[i - 1]) {//如果当前数和前一个数一样，上一个数没被选，那么这个数也跳过
                continue;
            }
            //选择当前数
            path.add(nums[i]);
            //递归处理下一个数
            backTrace(nums, target - nums[i], i + 1, path, res);
            //撤销选择
            path.remove(path.size() - 1);

        }
    }
}
