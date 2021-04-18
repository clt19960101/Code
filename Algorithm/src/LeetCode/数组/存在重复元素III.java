package LeetCode.数组;

import java.util.HashMap;

/**
 * @ClassName 存在重复元素III
 * @Description 220
 * @Author Langtao
 * @Date 2021/4/17 14:12
 * @Version V1.0
 */

public class 存在重复元素III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        HashMap<Long, Long> map = new HashMap<>();
        //桶的大小为 t + 1
        long w = (long) t + 1;
        for (int i = 0; i < n; i++) {
            //得到元素该放桶的索引
            long index = getId(nums[i], w);
            //如果桶存在了，就一定存在满足两个数之差的绝对值小于等于t
            if (map.containsKey(index)) {
                return true;
            }
            //判断相邻桶
            if (map.containsKey(index - 1) && Math.abs(map.get(index - 1) - (long) nums[i]) < w) {
                return true;
            }
            if (map.containsKey(index + 1) && Math.abs(map.get(index + 1) - (long) nums[i]) < w) {
                return true;
            }
            //创建桶
            map.put(index, (long) nums[i]);
            //滑动窗口
            if(i>=k){
                //滑动窗口向右移动一个位置,移除不满足的桶
                map.remove(getId(nums[i - k], w));
            }
        }
        return false;

    }

    private long getId(long num, long w) {
        long index;
        //对于正数情况
        if (num >= 0) {
            index = num / w;
        } else {
            //对于负数情况：假如-1~-6 w=5; -6应该在0号桶，但由于0号桶被0-5号元素占用,所以将桶整个
            //向左移动一个位置
            index = (num + 1) / w - 1;
        }
        return index;
    }
}
