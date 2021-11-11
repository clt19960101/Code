package Str;

import java.util.HashMap;
import java.util.HashSet;

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
     * ��������
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_1(String s) {
        int len = s.length();
        //�ж��ַ��Ƿ���ֹ�
        HashSet<Character> occ = new HashSet<>();

        //-1��ʾ��δ�ƶ���
        int end = -1, ans = 0;

        for (int i = 0; i < len; i++) {
            if (i != 0) {
                //��ָ�������ƶ�һ���Ƴ�һ���ַ�
                occ.remove(s.charAt(i - 1));
            }

            while (end + 1 < len && !occ.contains(s.charAt(end + 1))) {
                //��������ָ��
                occ.add(s.charAt(end + 1));
                end++;
            }
            //���ظ��ַ�
            // �� i �� rk ���ַ���һ�����������ظ��ַ��Ӵ�
            ans = Math.max(ans, end - i + 1);
        }
        return ans;
    }
}
