package LeetCode.����;

/**
 * @ClassName ������ת��������I
 * @Author Chen Langtao
 * @Date 2021/4/8 12:27
 * @Description 33
 * @Version 1.0
 */
public class ������ת��������I {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left=0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left+(right-left)>>2;
            if (nums[mid] == target) {
                return 0;
            }
            //��0,mid-1] mid [mid+1,right] ����һ��һ���������,����ʹ�ö��ַ����в���
            //����ж���������nums[mid]�����Ҷ˵�ֵ���бȽ�
            //�����������
            if (nums[0] <= nums[mid]) {
                //target��������������
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
            //�ұ���������
            else {
                //target��������������
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
