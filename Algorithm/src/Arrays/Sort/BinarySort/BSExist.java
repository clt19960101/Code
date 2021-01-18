package Arrays.Sort.BinarySort;

/**
 * @ClassName BSExist
 * @Description 在有序数组[2, 3, 5, 6, 7, 23, 54, 67, 78, 98, 100]中寻找是否存在23
 * @Author Langtao
 * @Date 2021/1/17 23:53
 * @Version V1.0
 */

public class BSExist {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 7, 23, 54, 67, 78, 98, 100};
        System.out.println(doBEExist(arr, 23));
    }

    private static boolean doBEExist(int[] arr, int num) {
        if (null == arr || arr.length == 0) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        int mid = 0;
        while (L < R) {
            //防止溢出
            mid = L + ((R - L) >> 1);
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return arr[mid] == num;

    }
}
