package LeetCode;

/**
 * @ClassName 平方数之和
 * @Description TODO
 * @Author Langtao
 * @Date 2021/4/28 23:38
 * @Version V1.0
 */

public class 平方数之和 {
    public boolean judgeSquareSum(int c) {
        long left=0;
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
