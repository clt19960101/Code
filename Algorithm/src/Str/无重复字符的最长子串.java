package Str;

import java.util.HashMap;

/**
 * @ClassName ���ظ��ַ�����Ӵ�
 * @Description 3
 * @Author Langtao
 * @Date 2021/4/22 23:00
 * @Version V1.0
 */

public class ���ظ��ַ�����Ӵ� {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int res = 0;
        //start:���ظ��ַ�����ʼλ��
        //end:���ظ��ַ�����ֹλ��
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
