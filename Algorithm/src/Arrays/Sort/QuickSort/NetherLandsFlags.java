package Arrays.Sort.QuickSort;

/**
 * @ClassName QuickSortExample1
 * @Author Chen Langtao
 * @Date 2021/2/11 8:03
 * @Description 给定一个数num和一个数组，将数组分为左中右两部分，其中左边部分小于num,中间等于num,右边部分大于num
 * @Version 1.0
 */
public class NetherLandsFlags {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 4, 2, 3, 5};
        int[] ints = doNetherlandsflags(arr, 0, arr.length - 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+",");
        }
    }

    /**
     * @Name doNetherlandsflags
     * @Param [arr, left, right]
     * @Retrun 返回等于num的左右边界
     * @Author Chen Langtao
     * @Date 2021/2/11 8:14
     * @Throws
     * @Description 一律以arr[R]做划分值
     */
    private static int[] doNetherlandsflags(int[] arr, int left, int right) {
        if (left > right) {
            return new int[]{-1, -1};
        }
        if (left == right) {
            return new int[]{left, right};
        }
        //小于区右边界
        int less = left - 1;
        //大于区左边界
        int more = right;
        //数组索引
        int index = left;
        while (index < more) {
            //当arr[i]==arr[right]时,less,more区不变，index++
            if (arr[index] == arr[right]) {
                index++;
            } else if (arr[index] < arr[right]) {
                //当arr[i]<num时,less右扩,index++
                swap(arr, index++, ++less);
            } else {
                //当arr[i]>num时,more左扩,index不变
                swap(arr, index, --more);
            }
        }
        //left..less  less+1..more-1   more..R-1   R
        //最后大于区第一个数和right交换
        swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int index1, int index2) {
        arr[index1] = arr[index1] ^ arr[index2];
        arr[index2] = arr[index1] ^ arr[index2];
        arr[index1] = arr[index1] ^ arr[index2];
    }
}
