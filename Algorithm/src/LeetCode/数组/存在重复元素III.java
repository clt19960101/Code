package LeetCode.����;

import java.util.HashMap;

/**
 * @ClassName �����ظ�Ԫ��III
 * @Description 220
 * @Author Langtao
 * @Date 2021/4/17 14:12
 * @Version V1.0
 */

public class �����ظ�Ԫ��III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        HashMap<Long, Long> map = new HashMap<>();
        //Ͱ�Ĵ�СΪ t + 1
        long w = (long) t + 1;
        for (int i = 0; i < n; i++) {
            //�õ�Ԫ�ظ÷�Ͱ������
            long index = getId(nums[i], w);
            //���Ͱ�����ˣ���һ����������������֮��ľ���ֵС�ڵ���t
            if (map.containsKey(index)) {
                return true;
            }
            //�ж�����Ͱ
            if (map.containsKey(index - 1) && Math.abs(map.get(index - 1) - (long) nums[i]) < w) {
                return true;
            }
            if (map.containsKey(index + 1) && Math.abs(map.get(index + 1) - (long) nums[i]) < w) {
                return true;
            }
            //����Ͱ
            map.put(index, (long) nums[i]);
            //��������
            if(i>=k){
                //�������������ƶ�һ��λ��,�Ƴ��������Ͱ
                map.remove(getId(nums[i - k], w));
            }
        }
        return false;

    }

    private long getId(long num, long w) {
        long index;
        //�����������
        if (num >= 0) {
            index = num / w;
        } else {
            //���ڸ������������-1~-6 w=5; -6Ӧ����0��Ͱ��������0��Ͱ��0-5��Ԫ��ռ��,���Խ�Ͱ����
            //�����ƶ�һ��λ��
            index = (num + 1) / w - 1;
        }
        return index;
    }
}
