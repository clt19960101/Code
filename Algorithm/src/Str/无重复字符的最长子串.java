package Str;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName 无重复字符的最长子串
 * @Description 3
 * @Author Langtao
 * @Date 2021/4/22 23:00
 * @Version V1.0
 */

public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int res = 0;
        //start:无重复字符串起始位置
        //end:无重复字符串终止位置
        for (int start = 0, end = 0; end < s.length(); end++) {
            char ele = s.charAt(end);
            if (hashMap.containsKey(ele)) {
                start = Math.max(hashMap.get(ele) + 1, start);
            }
            hashMap.put(ele, end);
            res = Math.max(res, end - start + 1);

        }
        return res;
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_1(String s) {
        int len = s.length();
        //判断字符是否出现过
        HashSet<Character> occ = new HashSet<>();

        //-1表示还未移动过
        int end = -1, ans = 0;

        for (int i = 0; i < len; i++) {
            if (i != 0) {
                //做指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }

            while (end + 1 < len && !occ.contains(s.charAt(end + 1))) {
                //不断右移指针
                occ.add(s.charAt(end + 1));
                end++;
            }
            //有重复字符
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, end - i + 1);
        }
        return ans;
    }
}
