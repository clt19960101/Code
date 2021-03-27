package Arrays.DoublePointer;
//26. ɾ�����������е��ظ���

/**
 * ���� nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * ����Ӧ�÷����µĳ��� 5, ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4��
 * <p>
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));

    }

    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow+1;
    }
}
