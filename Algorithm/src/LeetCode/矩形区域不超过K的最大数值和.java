package LeetCode;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @ClassName �������򲻳���K�������ֵ��
 * @Author Chen Langtao
 * @Date 2021/4/22 20:29
 * @Description 363
 * @Version 1.0
 */
public class �������򲻳���K�������ֵ�� {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        //����
        int m = matrix.length, n = matrix[0].length;
        //ö���ϱ߽�
        for (int i = 0; i < m; i++) {
            int[] sum = new int[n];
            //ö���±߽�i
            for (int j = i; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    sum[l] += matrix[j][l];//����ÿ�е�Ԫ�غ�
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
