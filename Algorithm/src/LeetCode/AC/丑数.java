package LeetCode.AC;

/**
 * @ClassName 丑数
 * @Description 264
 * @Author Langtao
 * @Date 2021/4/11 21:48
 * @Version V1.0
 */

public class 丑数 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        //下一个丑数是当前指针指向的丑数乘以对应的质因数
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2]*2;
            int num3 = dp[p3]*3;
            int num5 = dp[p5]*5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
