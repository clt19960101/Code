package Arrays.Sort;

/**
 * @ClassName QuickSortAlgorithm
 * @Description ���������㷨--���ݽṹ���㷨
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
        //�ų�����Ԫ��Ϊ1��0�����
        if (array.length <= 1) {
            return array;
        }
        //��ŦԪѡ��
        int pivot = getPivot(array, left, right);
        int i = left,j=right-1;
            while (array[++left]<pivot){}
            while (array[--right]>pivot){}
            if (i < j) {
                swap(array, left, right);
            } else {
                return array;
            }
        //������ŦԪ��i��ָԪ��
        swap(array,i, right-1);
        quickSort(array, left, i - 1);
        quickSort(array, i+1,right);
        return array;
    }

    //������ֵ�ָ
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
