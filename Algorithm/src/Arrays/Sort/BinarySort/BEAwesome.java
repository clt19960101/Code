package Arrays.Sort.BinarySort;

/**
 * @ClassName BEAwesome
 * @Description 局部最小值问题
 * @Author Langtao
 * @Date 2021/1/19 22:25
 * @Version V1.0
 */

public class BEAwesome {
    public static void main(String[] args) {
        int[] arr = {43, 42, 6, 86, 34, 78, 5, 3, 86, 4, 8};
        System.out.println(doBEAwesome(arr));

    }

    private static int doBEAwesome(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
