package Arrays.Sort;

/**
 * @ClassName MergeSort
 * @Description �鲢����
 * @Author Langtao
 * @Date 2021/1/31 21:08
 * @Version V1.0
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2,5};
        //�ݹ鷽��
        doMergeSort1(arr, 0, arr.length - 1);
        //�ǵݹ鷽��
//        doMergeSort2(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + ",");
//        }
        //��ϰһ����һ�������У�һ������߱���С�������ܺͽи�����С�ͣ�����С���ۼ�������������С��
        //��[1,3,4,2,5]
        //1���û��С��1������0
        //3�����С��3������1
        //4�����С��4������1,3
        //2���ûС��2������1
        //5�����С��5������1,3,4,2
        //����С�ͣ�1+1+3+1+1+3+4+2=16
        System.out.println(smallSum(arr, 0, arr.length - 1));
    }


    /**
     * @return
     * @Author Langtao
     * @Description �ù鲢������С��
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
     * @Description �ϲ������Ǽ����С�ͣ�������������Աȵ������ʱ���涨��merger�����������
     * @Date 22:30 2021/2/8
     * @Param
     */

    private static int mergeSum(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        //help�����е�ָ��
        int i = 0;
        //��벿�ֵ�ָ��
        int p1 = left;
        //�Ұ벿�ֵ�ָ��
        int p2 = mid + 1;
        //�ȹ鲢�����ĵط�
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
     * @Description �ݹ�ʵ�ֹ鲢����
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
        //�ϲ�����
        merge(arr, left, mid, right);


    }


    /**
     * @return
     * @Author Langtao
     * @Description �ϲ�����
     * @Date 22:21 2021/2/8
     * @Param
     */

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        //help�����е�ָ��
        int i = 0;
        //��벿�ֵ�ָ��
        int p1 = left;
        //�Ұ벿�ֵ�ָ��
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //ʣ��Ĳ��ֵ�ֵ
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
     * @Description �ǵݹ�ʵ�ֹ鲢����
     * @Date 22:21 2021/2/8
     * @Param
     */
    private static void doMergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //��ǰ���������Ԫ�ظ���
        int mergerSize = 1;
        int N = arr.length;
        //��mergeSize==Nʱ���������
        while (mergerSize < N) {
            int L = 0;
            while (L < N) {
                //���飺L-M  ���飺M+1-R(���������ʱmergeSize��)
                int M = L + mergerSize - 1;
                if (M >= N) {
                    break;
                }
                //�ұ߽�
                int R = Math.min(M + mergerSize, N - 1);
                merge(arr, L, M, R);
                //��һ�������������
                L = R + 1;
            }
            //�Ӳ��Ӳ�Ӱ�죬�ô��Ƿ�ֹԽ��
            if (mergerSize > N / 2) {
                break;
            }
            mergerSize <<= 1;

        }

    }
}
