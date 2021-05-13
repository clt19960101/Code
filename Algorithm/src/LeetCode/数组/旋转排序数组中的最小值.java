package LeetCode.����;

/**
 * @ClassName ��ת���������е���Сֵ
 * @Author Chen Langtao
 * @Date 2021/4/9 23:46
 * @Description 153
 * @Version 1.0
 */
public class ��ת���������е���Сֵ {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        //��left==rightʱ���ҵ���
        while (left < right) {
            int mid = left + (right - left) / 2;
            //mid�ұ�һ��������ģ���Сֵһ����mid�Ҳ��Ԫ��
            if (nums[mid] < nums[right]) {
                //��Сֵ������nums[mid]
                right = mid;

            }
            //�������������ظ�ֵʱ����nums[mid] == nums[right],right--;
            else if (nums[mid] == nums[right]) {
                right--;
            }
            //�����鲻�������ظ�ֵʱ����left==rightʱ��������ѭ����������nums[mid]==nums[right]�����
            //mid�������һ����������Ҷ���������Ŀ��ֵ
            else {
                //��Сֵ��������nums[mid]
                left = mid + 1;

            }
        }
        return nums[left];

    }
}
