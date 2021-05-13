package LeetCode;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @ClassName 矩形区域不超过K的最大数值和
 * @Author Chen Langtao
 * @Date 2021/4/22 20:29
 * @Description 363
 * @Version 1.0
 */
public class 矩形区域不超过K的最大数值和 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        //行列
        int m = matrix.length, n = matrix[0].length;
        //枚举上边界
        for (int i = 0; i < m; i++) {
            int[] sum = new int[n];
            //枚举下边界i
            for (int j = i; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    sum[l] += matrix[j][l];//更新每列得元素和
                    TreeSet<Object> sumSet = new TreeSet<>();
                    sumSet.add(0);
                    int s = 0;
                    for (int v : sum) {
                        s += v;
                        Integer ceil = (Integer) sumSet.ceiling(s - k);
                        if (ceil != null) {
                            ans = Math.max(ans, s - ceil);
                        }
                        sumSet.add(s);
                    }
                }

            }
        }
        return ans;

    }
}
