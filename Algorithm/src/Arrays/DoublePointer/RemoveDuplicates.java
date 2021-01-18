package Arrays.DoublePointer;
//26. 删除排序数组中的重复项
/**
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(removeDuplicates(nums));

    }
    public static int removeDuplicates(int[] nums) {
        //慢指针
        int i=0;
        //j快指针
        for (int j=0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
               nums[i]=nums[j];
            }
        }
        return i+1;
    }
}
