package Arrays.DoublePointer;
//26. ɾ�����������е��ظ���
/**
 * ���� nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * ����Ӧ�÷����µĳ��� 5, ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4��
 *
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 *
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(removeDuplicates(nums));

    }
    public static int removeDuplicates(int[] nums) {
        //��ָ��
        int i=0;
        //j��ָ��
        for (int j=0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
               nums[i]=nums[j];
            }
        }
        return i+1;
    }
}
