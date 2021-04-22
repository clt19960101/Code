package Str;

import java.util.HashMap;

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
        for (int start = 0, end = 0; end <s.length(); end++) {
            char ele = s.charAt(end);
            if (hashMap.containsKey(ele)) {
                start = Math.max(hashMap.get(ele)+1, start);
            }
            hashMap.put(ele, end);
            res = Math.max(res, end - start + 1);

        }
        return res;
    }
}
