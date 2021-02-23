package Arrays.Sort;

/**
 * @ClassName MergeSort
 * @Description 归并排序
 * @Author Langtao
 * @Date 2021/1/31 21:08
 * @Version V1.0
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2,5};
        //递归方法
        doMergeSort1(arr, 0, arr.length - 1);
        //非递归方法
//        doMergeSort2(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + ",");
//        }
        //练习一：在一个数组中，一个数左边比它小的数的总和叫该数的小和，所有小和累加起来，叫数组小和
        //如[1,3,4,2,5]
        //1左边没有小于1的数：0
        //3左边有小于3的数：1
        //4左边有小于4的数：1,3
        //2左边没小于2的数：1
        //5左边有小于5的数：1,3,4,2
        //数的小和：1+1+3+1+1+3+4+2=16
        System.out.println(smallSum(arr, 0, arr.length - 1));
    }


    /**
     * @return
     * @Author Langtao
     * @Description 用归并排序求小和
     * @Date 22:22 2021/2/8
     * @Param
     */

    private static int smallSum(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return smallSum(arr, left, mid)
                + smallSum(arr, mid + 1, right)
                + mergeSum(arr, left, mid, right);

    }

    /**
     * @return
     * @Author Langtao
     * @Description 合并数组是计算出小和，当左右子数组对比的数相等时，规定先merger右子数组的数
     * @Date 22:30 2021/2/8
     * @Param
     */

    private static int mergeSum(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        //help数组中的指针
        int i = 0;
        //左半部分的指针
        int p1 = left;
        //右半部分的指针
        int p2 = mid + 1;
        //比归并排序多的地方
        int res = 0;
        while (p1 <= mid && p2 <= right) {
            res += arr[p1] < arr[p2] ? (right - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (int i1 = 0; i1 < help.length; i1++) {
            arr[left + i1] = help[i1];
        }
        return res;
    }

    /**
     * @return void
     * @Author Langtao
     * @Description 递归实现归并排序
     * @Date 22:20 2021/2/8
     * @Param arr, left, right
     */

    private static void doMergeSort1(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        doMergeSort1(arr, left, mid);
        doMergeSort1(arr, mid + 1, right);
        //合并数组
        merge(arr, left, mid, right);


    }


    /**
     * @return
     * @Author Langtao
     * @Description 合并函数
     * @Date 22:21 2021/2/8
     * @Param
     */

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        //help数组中的指针
        int i = 0;
        //左半部分的指针
        int p1 = left;
        //右半部分的指针
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //剩余的部分的值
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (int i1 = 0; i1 < help.length; i1++) {
            arr[left + i1] = help[i1];
        }
    }


    /**
     * @return
     * @Author Langtao
     * @Description 非递归实现归并排序
     * @Date 22:21 2021/2/8
     * @Param
     */
    private static void doMergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //当前有序的左组元素个数
        int mergerSize = 1;
        int N = arr.length;
        //当mergeSize==N时数组变有序
        while (mergerSize < N) {
            int L = 0;
            while (L < N) {
                //左组：L-M  右组：M+1-R(理想情况下时mergeSize个)
                int M = L + mergerSize - 1;
                if (M >= N) {
                    break;
                }
                //右边界
                int R = Math.min(M + mergerSize, N - 1);
                merge(arr, L, M, R);
                //下一组待排序子数组
                L = R + 1;
            }
            //加不加不影响，好处是防止越界
            if (mergerSize > N / 2) {
                break;
            }
            mergerSize <<= 1;

        }

    }
}
