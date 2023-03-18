package Arrays.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName FindCombinations
 * @Description ����һ������n������array��һ��targetֵ�����ҳ�array�����п��ܼ���һ�����targetֵ�����
 * ÿ��Ԫ��ֻ����һ�Σ����ظ���ͬ�������ֻ���һ��
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
        if (target == 0) {//�ҵ�һ�����
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length ; i++) {
            if (nums[i] > target) {//�����ǰ������targetֱ�ӷ���
                break;
            }
            if (i > start && nums[i] == nums[i - 1]) {//�����ǰ����ǰһ����һ������һ����û��ѡ����ô�����Ҳ����
                continue;
            }
            //ѡ��ǰ��
            path.add(nums[i]);
            //�ݹ鴦����һ����
            backTrace(nums, target - nums[i], i + 1, path, res);
            //����ѡ��
            path.remove(path.size() - 1);

        }
    }
}
