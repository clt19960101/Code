package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ֻ����һ�ε�����II
 * @Description 137
 * @Author Langtao
 * @Date 2021/4/30 23:42
 * @Version V1.0
 */

public class ֻ����һ�ε�����II {
    //hash��
    public int singleNumber_Hash(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = nums[0];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ans = entry.getKey();
                break;
            }
        }
        return ans;
    }

    //����ȷ��ÿһ��������λ
    //�𰸵ĵ�iλ����������0��1�������������������Σ���ô��iλ������Ϊ����0������1
    //������һ�ֶ���3�ı���
    public int singleNumber_01(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            //��iλ�����Ƴ��ִ���
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
