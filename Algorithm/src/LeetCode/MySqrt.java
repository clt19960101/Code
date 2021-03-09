package LeetCode;

/**
 * @ClassName MySqrt
 * @Description 二分查找
 * https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
 * 时间复杂度：O(logx)，即为二分查找需要的次数。
 * 空间复杂度：O(1)
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
        //由于 x 平方根的整数部分 ans 是满足 k^2 ≤x 的最大 k 值，因此我们可以对 k 进行二分查找，从而得到答案
        //二分查找的下界为 0
        int left = 0;
        //上界可以粗略地设定为 x
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
