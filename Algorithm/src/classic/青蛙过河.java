package classic;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ���ܹ���
 * @Description 403
 * @Author Langtao
 * @Date 2021/4/30 0:14
 * @Version V1.0
 */

public class ���ܹ��� {

    private Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    /**
     * ��������-��ʱ
     * ��ʧһ���ԣ����ǵ�i��ʯͷ��Ծ��Ҫ������
     * 1.֪����ǰʯͷ���ڵ�����index
     * 2.��Ҫ֪����ǰλ��������һ��ʯ��ͨ����Ծ���ٲ���������K
     * @param stones
     * @return
     */
    public boolean canCross_DFS(int[] stones) {
        int n = stones.length;
        //��ʯ����Ϣ����map�����ڻ�ȡʯ�ӵ�����
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }

        //��һ�����Ǿ�������1�����һ��ʯ��
        if (!map.containsKey(1)) {
            return true;
        }
        return dfs(stones, n, 1, 1);



    }
    /**
     * @Author Langtao
     * @Description TODO
     * @Date 12:09 2021/4/30
     * @Param index ��ǰ����ʯ���±� k��һ����Ծ����
     * @return boolean
     */
    private boolean dfs(int[] stones, int n, int index, int k) {
        if (index == n - 1) {
            //���һ��ʯ��
            return true;
        }
        //K+1|K-1|K
        for (int i = -1; i <= 1; i++) {
            //�����ԭ��̤����ֱ������
            if (k + i == 0) {
                continue;
            }
            //��һ����ʯ�ӵ�����λ��
            int next = stones[index] + k + i;
            //���������һ��ʯ����dfs��ȥ
            if (map.containsKey(next)) {
                boolean cur = dfs(stones, n, map.get(next), k + i);
                if (cur) {
                    return true;
                }

            }
        }
        return false;


    }

    //Ĭ��ֵ0����״̬��δ���㣬1����״̬Ϊtrue��-1����״̬�Ѽ��㵫�ǽ��Ϊfalse
    private Map<String, Boolean> cache = new HashMap<>();
    public boolean canCross_DFS_���仯����(int[] stones) {
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        if (!map.containsKey(1)) {
            return false;
        }
        return dfs_���仯����(stones, n, 1, 1);


    }

    private boolean dfs_���仯����(int[] stones, int n, int i, int k) {
        //ƴ��key
        String key = i + "_" + k;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (i == n - 1) {
            return true;
        }
        for (int j = -1; j <= 1; j++) {
            if (k + j == 0) {
                continue;
            }
            int next = stones[i] + k + j;
            if (map.containsKey(next)) {
                boolean cur = dfs(stones, n, map.get(next), k + j);
                cache.put(key, cur);
                if (cur) {
                    return true;
                }
            }
        }
        cache.put(key, false);
        return false;
    }


    public boolean canCross_DP(int[] stones) {
        int n = stones.length;
        //dp[i][k]����ǰ����ʯ��i�Ǿ�����һ����Ծ����k��ת������
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; i++) {
            //��һ����Ծ����
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; --j) {
                //����
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                //j������һ��ʯ�ӱ��
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }
}
