package classic;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName 青蛙过河
 * @Description 403
 * @Author Langtao
 * @Date 2021/4/30 0:14
 * @Version V1.0
 */

public class 青蛙过河 {

    private Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    /**
     * 暴力搜索-超时
     * 不失一般性，考虑第i块石头跳跃需要的条件
     * 1.知道当前石头所在的索引index
     * 2.需要知道当前位置是由上一个石子通过跳跃多少步，即步长K
     * @param stones
     * @return
     */
    public boolean canCross_DFS(int[] stones) {
        int n = stones.length;
        //将石子信息放入map，便于获取石子的索引
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }

        //第一步的是经过步长1到达第一块石子
        if (!map.containsKey(1)) {
            return true;
        }
        return dfs(stones, n, 1, 1);



    }
    /**
     * @Author Langtao
     * @Description TODO
     * @Date 12:09 2021/4/30
     * @Param index 当前所在石子下标 k上一次跳跃步数
     * @return boolean
     */
    private boolean dfs(int[] stones, int n, int index, int k) {
        if (index == n - 1) {
            //最后一颗石子
            return true;
        }
        //K+1|K-1|K
        for (int i = -1; i <= 1; i++) {
            //如果是原地踏步，直接跳过
            if (k + i == 0) {
                continue;
            }
            //下一步的石子的理论位置
            int next = stones[index] + k + i;
            //如果存在下一步石子则dfs下去
            if (map.containsKey(next)) {
                boolean cur = dfs(stones, n, map.get(next), k + i);
                if (cur) {
                    return true;
                }

            }
        }
        return false;


    }

    //默认值0代表状态尚未计算，1代表状态为true，-1代表状态已计算但是结果为false
    private Map<String, Boolean> cache = new HashMap<>();
    public boolean canCross_DFS_记忆化搜索(int[] stones) {
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        if (!map.containsKey(1)) {
            return false;
        }
        return dfs_记忆化搜索(stones, n, 1, 1);


    }

    private boolean dfs_记忆化搜索(int[] stones, int n, int i, int k) {
        //拼接key
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
        //dp[i][k]代表当前所处石子i是经过上一次跳跃距离k跳转而来的
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; i++) {
            //上一次跳跃距离
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; --j) {
                //步长
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                //j代表上一次石子编号
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }
}
