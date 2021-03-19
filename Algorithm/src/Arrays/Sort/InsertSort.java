package Arrays.Sort;

/**
 * @ClassName InsertSort
 * @Description ��������
 * @Author Langtao
 * @Date 2021/1/17 23:00
 * @Version V1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {85, 8, 54, 3, 23};
        doInsert(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    private static void doInsert(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //0~i��������
        for (int i = 0; i < arr.length; i++) {
            //ÿ�θ�ǰһ�����Աȣ���С��ǰһ�����򽻻�
            //ע��j--
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }


    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

}
