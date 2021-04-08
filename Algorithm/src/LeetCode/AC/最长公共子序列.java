package LeetCode.AC;

/**
 * @ClassName 最长公共子序列
 * @Description 1143
 * @Author Langtao
 * @Date 2021/4/3 22:20
 * @Version V1.0
 */

public class 最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(),n=text2.length();
        //dp[0][j]=dp[i][0]=0
        int [][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            char char1 = text1.charAt(i-1);
            for(int j=1;j<=n;j++){
                char char2 = text2.charAt(j-1);
                if(char1==char2){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];

    }
}
