package LeetCode.DP;

/**
 * @ClassName ������Ӵ�
 * @Author Chen Langtao
 * @Date 2021/12/7 22:13
 * @Description 5
 * @Version 1.0
 */
public class ������Ӵ� {
    public static void main(String[] args) {

    }


    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;

        //dp[i][j]��ʾ�ִ�����߽�i���ұ߽�j�Ƿ��ǻ����Ӵ�
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
                //ֻҪdp[i][j]==true�������ͱ�ʾs[i....j]�ǻ����ִ�����ʱ��¼���ĳ��Ⱥ���ʵλ��
                if (dp[i][j] == true&&j - i + 1>maxLen) {
                    begin = i;
                    maxLen = j - i + 1;
                }

            }

        }
        return s.substring(begin, begin + maxLen);

    }
}
