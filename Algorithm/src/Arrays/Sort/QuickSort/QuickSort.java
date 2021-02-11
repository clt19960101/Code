package Arrays.Sort.QuickSort;

/**
 * @ClassName QuickSort
 * @Author Chen Langtao
 * @Date 2021/2/11 7:59
 * @Description 快速排序
 * @Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 5};
        doQuickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    private static void doQuickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //快排1.0版本 每次只搞定一个数
//        doQuickSort1(arr, 0, arr.length - 1);
        //快排2.0版本 每次搞定等于num的数
//        doQuickSort2(arr, 0, arr.length - 1);
        //快排3.0版本 时间复杂度：O(N*logN) 空间复杂度：好情况O(logN)  坏情况O(N)
        //随机选一个数
        doQuickSort3(arr, 0, arr.length - 1);

    }

    private static void doQuickSort3(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        //随机选一个数与arr[right]交换
        swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
        int[] rang = partition2(arr, left, right);
        doQuickSort3(arr, left, rang[0] - 1);
        doQuickSort3(arr, rang[1] + 1, right);

    }

    private static void doQuickSort2(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int[] rang = partition2(arr, left, right);
        doQuickSort2(arr, left, rang[0] - 1);
        doQuickSort2(arr, rang[1] + 1, right);
    }

    private static void doQuickSort1(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int M = partition1(arr, left, right);
        doQuickSort1(arr, left, M - 1);
        doQuickSort1(arr, M + 1, right);
    }

    private static int[] partition2(int[] arr, int left, int right) {
        if (right < left) {
            return new int[]{-1, -1};
        }
        if (left == right) {
            return new int[]{left, right};
        }
        //数组索引
        int index = left;
        //小于区
        int less = left - 1;
        //大于区
        int more = right;
        while (index < more) {
            if (arr[index] == arr[right]) {
                index++;
            } else if (arr[index] < arr[right]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
        swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    private static int partition1(int[] arr, int left, int right) {
        if (right < left) {
            return -1;
        }
        if (left == right) {
            return left;
        }
        //数组索引
        int index = left;
        //小于等于区
        int isEqual = left - 1;
        while (index < right) {
            if (arr[index] <= arr[right]) {
                swap(arr, index, ++isEqual);
            }
            index++;
        }
        swap(arr, ++isEqual, right);
        return isEqual;
    }

    private static void swap(int[] arr, int i0, int i1) {
        int temp = arr[i0];
        arr[i0] = arr[i1];
        arr[i1] = temp;
        //异化运算交换值不适用于处于同一个地址的数
//        arr[i0] = arr[i0] ^ arr[i1];
//        arr[i1] = arr[i0] ^ arr[i1];
//        arr[i0] = arr[i0] ^ arr[i1];
    }
}
