package Arrays.Sort.BinarySort;

/**
 * @ClassName BSNearLeftOrRight
 * @Description 在有序数组[1, 5, 7, 9, 10]中寻找大于等于(或小于等于)23最左侧的数
 * @Author Langtao
 * @Date 2021/1/18 23:33
 * @Version V1.0
 */

public class BSNearLeftOrRight {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 9, 10};
        System.out.println(doBSNearLeft(arr, 22));
        System.out.println(doBSNearRight(arr, 6));
    }

    private static int doBSNearLeft(int[] arr, int i) {
        int L = 0;
        int R = arr.length - 1;
        //记录最左侧的对号
        int index = -1;
        while (L <= R) {
            int midIndex = L + ((R - L) >> 1);
            if (arr[midIndex] >= i) {
                index = midIndex;
                R = midIndex - 1;
            } else {
                L = midIndex + 1;
            }
        }
        return index;
    }

    private static int doBSNearRight(int[] arr, int i) {
        int L = 0;
        int R = arr.length - 1;
        //记录最右侧的对号
        int index = arr.length;
        while (L <= R) {
            int midIndex = L + ((R - L) >> 1);
            if (arr[midIndex] >= i) {
                R = midIndex - 1;
            } else {
                index = midIndex;
                L = midIndex + 1;
            }
        }
        return index;
    }
}
