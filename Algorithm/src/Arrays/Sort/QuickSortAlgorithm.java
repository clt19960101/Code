package Arrays.Sort;

/**
 * @ClassName QuickSortAlgorithm
 * @Description 快速排序算法--数据结构与算法
 * @Author Langtao
 * @Date 2021/1/6 22:20
 * @Version V1.0
 */

public class QuickSortAlgorithm {
    public static void main(String[] args) {
        int[] array = {8, 1, 4, 9, 6, 3, 5, 2, 7, 0};
        int[] ints = quickSort(array, 0, array.length-1);
        for (int anInt : ints) {
            System.out.print(anInt+",");
        }

    }

    private static int[] quickSort(int[] array, int left, int right) {
        //排除数组元素为1或0的情况
        if (array.length <= 1) {
            return array;
        }
        //枢纽元选择
        int pivot = getPivot(array, left, right);
        int i = left,j=right-1;
            while (array[++left]<pivot){}
            while (array[--right]>pivot){}
            if (i < j) {
                swap(array, left, right);
            } else {
                return array;
            }
        //交换枢纽元和i所指元素
        swap(array,i, right-1);
        quickSort(array, left, i - 1);
        quickSort(array, i+1,right);
        return array;
    }

    //三数中值分割法
    private static int getPivot(int[] array, int left, int right) {
        int center = (left + right) / 2;
        if (array[left] > array[center]) {
            swap(array,array[left], array[center]);
        }
        if (array[left] > array[right]) {
            swap(array,array[left], array[right]);
        }
        if (array[center] > array[right]) {
            swap(array,array[center], array[right]);
        }
        swap(array,array[center], array[right - 1]);
        return array[right - 1];
    }

    private static void swap(int[]arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
