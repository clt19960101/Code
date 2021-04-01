package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName 子集I
 * @Description 78
 * @Author Langtao
 * @Date 2021/3/31 22:45
 * @Version V1.0
 */

public class 子集I {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    /**
     * 记原序列中的元素总数为n.原序列中的每个数字可能有两种状态，即在子集中和不在子集中，我们用
     * 1代表在子集中，用0代表不在子集中，那么每一个子集可以对应一个长度为n的0/1序列，第i位表示
     * ai是否在子集中.
     * 可以发现 0/1 序列对应的二进制数正好从 0 到 2^n - 1
     * 我们可以枚举 mask∈[0,2^n-1],mask 的二进制表示是一个 0/1 序列，我们可以按照这个 0/1
     * 序列在原集合当中取数。当我们枚举完所有 2^n个 mask，我们也就能构造出所有的子集
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        //元素总个数
        int n = nums.length;
        //(1 << n) == 2^n
        for (int mask = 0; mask < (1 << n); mask++) {
            //每次的子集
            t.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[n - i - 1]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;


    }
}
