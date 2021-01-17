package Arrays.Sort;

/**
 * @ClassName SelectSort
 * @Description —°‘Ò≈≈–Ú
 * @Author Langtao
 * @Date 2021/1/17 17:15
 * @Version V1.0
 */

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {85, 8, 54, 3, 23};
        doSelect(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }

    private static void doSelect(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int i1 = i+1; i1 < arr.length; i1++) {
                minIndex = arr[minIndex] > arr[i1] ? i1 : minIndex;
            }
            swap(arr,i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1]=temp;
    }

}
