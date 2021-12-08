package LeetCode.DP;

/**
 * @ClassName 最长回文子串
 * @Author Chen Langtao
 * @Date 2021/12/7 22:13
 * @Description 5
 * @Version 1.0
 */
public class 最长回文子串 {
    public static void main(String[] args) {

    }


    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;

        //dp[i][j]表示字串从左边界i到右边界j是否是回文子串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - 1 - (i + 1) + 1 < 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //只要dp[i][j]==true成立，就表示s[i....j]是回文字串，此时记录回文长度和其实位置
                if (dp[i][j] == true&&j - i + 1>maxLen) {
                    begin = i;
                    maxLen = j - i + 1;
                }

            }

        }
        return s.substring(begin, begin + maxLen);

    }
}
