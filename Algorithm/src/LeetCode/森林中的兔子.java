package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName 森林中的兔子
 * @Description 781
 * @Author Langtao
 * @Date 2021/4/4 13:14
 * @Version V1.0
 */

public class 森林中的兔子 {
    public int numRabbits(int[] answers) {
        /**
         * 一般地，如果有x只兔子回答y,那么至少有x/(y+1)向上取整种颜色
         * 且每种颜色至少有x/(y+1)向上取整*(y+1)个兔子
         * 每种颜色兔子数累加便得到结果
         */
        //统计回答相同的兔子个数
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int y : answers) {
            counts.put(y, counts.getOrDefault(y, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            //回答y的数量x
            Integer x = entry.getValue();
            //回答y
            Integer y = entry.getKey();
            //Math.ceil(x/(y+1))==(x+y)/(y+1)
            res += (x + y) / (y + 1) * (y + 1);
        }
        return res;
    }

}
