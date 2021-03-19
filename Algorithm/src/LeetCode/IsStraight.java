package LeetCode;

import java.util.HashSet;

/**
 * @ClassName IsStraight
 * @Description �˿��е�˳��
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/
 * @Author Langtao
 * @Date 2021/3/15 22:40
 * @Version V1.0
 */

public class IsStraight {
    public static void main(String[] args) {
        /**
         * ���˿����������5���ƣ��ж��ǲ���һ��˳�ӣ�����5�����ǲ��������ġ�
         * 2��10Ϊ���ֱ���AΪ1��JΪ11��QΪ12��KΪ13������С��Ϊ 0 ��
         * ���Կ����������֡�A ������Ϊ 14��
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
