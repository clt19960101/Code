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
        int[] arr = new int[]{2, 35, 6, 2, 1, 5, 63, 34};
        //�ݹ鷽��
        doMergeSort1(arr,0,arr.length-1);
        //�ǵݹ鷽��
        doMergeSort2(arr,0,arr.length-1);
    }

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

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;

    }

    private static void doMergeSort2(int[] arr, int left, int right) {

    }
}
