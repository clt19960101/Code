package LeetCode;

/**
 * @ClassName MySqrt
 * @Description ���ֲ���
 * https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
 * ʱ�临�Ӷȣ�O(logx)����Ϊ���ֲ�����Ҫ�Ĵ�����
 * �ռ临�Ӷȣ�O(1)
 * @Author Langtao
 * @Date 2021/3/9 23:03
 * @Version V1.0
 */

public class MySqrt {
    public static void main(String[] args) {
        int x = 6;
        System.out.println(mySqrt(x));
    }

    private static int mySqrt(int x) {
        //���� x ƽ�������������� ans ������ k^2 ��x ����� k ֵ��������ǿ��Զ� k ���ж��ֲ��ң��Ӷ��õ���
        //���ֲ��ҵ��½�Ϊ 0
        int left = 0;
        //�Ͻ���Դ��Ե��趨Ϊ x
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
