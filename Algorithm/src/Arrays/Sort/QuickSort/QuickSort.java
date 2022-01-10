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
        int[] arr = new int[]{1, 6, 5, 6, 64, 7, 87, 98};
        if (arr == null || arr.length < 2) {
            return;
        }
        doQuickSort3(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    private static void doQuickSort(int[] arr, int left, int right) {
        //快排1.0版本 每次只搞定一个数，以最后一个值为划分值 O(N^2)
//        doQuickSort1(arr, 0, arr.length - 1);
        //快排2.0版本 每次搞定等于num的数  O(N^2)
//        doQuickSort2(arr, 0, arr.length - 1);
        //快排3.0版本 时间复杂度：O(N*logN) 空间复杂度：好情况O(logN)  坏情况O(N)
        //随机选一个数
        doQuickSort3(arr, 0, arr.length - 1);

    }

    private static void doQuickSort3(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
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
        //没办法划分，返回无效值
        if (right < left) {
            return new int[]{-1, -1};
        }
        //左边界到右边界只有一个数
        if (left == right) {
            return new int[]{left, right};
        }
        //随机选一个数与arr[right]交换 让左右两侧范围差不多
        swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
        //数组索引
        int index = left;
        //小于区
        int less = left - 1;
        //大于区
        int more = right;
        while (index < more) {
            //当arr[i]==arr[right]时,less,more区不变，index++
            if (arr[index] == arr[right]) {
                index++;
            } else if (arr[index] < arr[right]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
        //left..less  less+1..more-1   more..R-1   R
        //最后大于区第一个数和right交换
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
            //如果i所指当前数小于等于arr[right],将该数和小于等于区的下一个数交换,小于等于区向右扩
            if (arr[index] <= arr[right]) {
                swap(arr, index, ++isEqual);
            }
            //什么都不做,index++
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
