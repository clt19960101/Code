package LeetCode.DP;

import java.util.*;

/**
 * @ClassName 买卖股票的最佳时机II_122
 * @Author Chen Langtao
 * @Date 2021/11/21 11:31
 * @Description TODO
 * @Version 1.0
 */
public class 买卖股票的最佳时机II_122 {
    public static void main(String[] args) {

    }

    /**
     *
     * @param prices
     * @return
     */
    public int maxProfit_1(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[len-1][0];
    }

    /**
     *
     * @param prices
     * @return
     */
    public int maxProfit_2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[] cash = new int[len];
        int[] stock = new int[len];

        //持有现金
        cash[0] = 0;
        //持有股票
        stock[0] = -prices[0];

        for (int i = 0; i < len; i++) {
            cash[i] = Math.max(cash[i - 1], stock[i - 1] + prices[i]);
            stock[i] = Math.max(stock[i - 1], cash[i-1] - prices[i]);
        }
        return cash[len-1];
    }

    /**
     * 优化空间
     * @param prices
     * @return
     */
    public int maxProfit_3(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int preCash = 0;
        int preHold = -prices[0];

        for (int i = 0; i < len; i++) {
            preCash = Math.max(preCash, preHold + prices[i]);
            preHold = Math.max(preHold, preCash - prices[i]);
        }
        return preCash;
    }

    /**
     * 贪心算法
     * @param prices
     * @return
     */
    public int maxProfit_4(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int maxProfit = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

}
