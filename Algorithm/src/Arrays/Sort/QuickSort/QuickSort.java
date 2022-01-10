package Arrays.Sort.QuickSort;

/**
 * @ClassName QuickSort
 * @Author Chen Langtao
 * @Date 2021/2/11 7:59
 * @Description ��������
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
        //����1.0�汾 ÿ��ֻ�㶨һ�����������һ��ֵΪ����ֵ O(N^2)
//        doQuickSort1(arr, 0, arr.length - 1);
        //����2.0�汾 ÿ�θ㶨����num����  O(N^2)
//        doQuickSort2(arr, 0, arr.length - 1);
        //����3.0�汾 ʱ�临�Ӷȣ�O(N*logN) �ռ临�Ӷȣ������O(logN)  �����O(N)
        //���ѡһ����
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
        //û�취���֣�������Чֵ
        if (right < left) {
            return new int[]{-1, -1};
        }
        //��߽絽�ұ߽�ֻ��һ����
        if (left == right) {
            return new int[]{left, right};
        }
        //���ѡһ������arr[right]���� ���������෶Χ���
        swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
        //��������
        int index = left;
        //С����
        int less = left - 1;
        //������
        int more = right;
        while (index < more) {
            //��arr[i]==arr[right]ʱ,less,more�����䣬index++
            if (arr[index] == arr[right]) {
                index++;
            } else if (arr[index] < arr[right]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
        //left..less  less+1..more-1   more..R-1   R
        //����������һ������right����
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
        //��������
        int index = left;
        //С�ڵ�����
        int isEqual = left - 1;
        while (index < right) {
            //���i��ָ��ǰ��С�ڵ���arr[right],��������С�ڵ���������һ��������,С�ڵ�����������
            if (arr[index] <= arr[right]) {
                swap(arr, index, ++isEqual);
            }
            //ʲô������,index++
            index++;
        }
        swap(arr, ++isEqual, right);
        return isEqual;
    }

    private static void swap(int[] arr, int i0, int i1) {
        int temp = arr[i0];
        arr[i0] = arr[i1];
        arr[i1] = temp;
        //�컯���㽻��ֵ�������ڴ���ͬһ����ַ����
//        arr[i0] = arr[i0] ^ arr[i1];
//        arr[i1] = arr[i0] ^ arr[i1];
//        arr[i0] = arr[i0] ^ arr[i1];
    }
}
