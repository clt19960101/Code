package LeetCode;

import java.util.HashSet;

/**
 * @ClassName IsStraight
 * @Description 扑克中的顺子
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/
 * @Author Langtao
 * @Date 2021/3/15 22:40
 * @Version V1.0
 */

public class IsStraight {
    public static void main(String[] args) {
        /**
         * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
         * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
         * 可以看成任意数字。A 不能视为 14。
         */
        int[] arr = new int[]{1, 0, 3, 5, 2};
        System.out.println(doIsStraight(arr));
    }

    private static boolean doIsStraight(int[] arr) {
        HashSet<Integer> integers = new HashSet<>();
        int max = 0;
        int min = 14;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            max = Math.max(max, arr[i]);
            min = Math.min(max, arr[i]);
            integers.add(arr[i]);
        }
        return max - min < 5;
    }
}
