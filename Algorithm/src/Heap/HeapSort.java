package Heap;

/**
 * @ClassName HeapSort
 * @Author Chen Langtao
 * @Date 2021/2/15 17:17
 * @Description ������ 1����֯�ɴ���� 2������
 * @Version 1.0
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {12, 23, 4, 2, 4, 53, 3};
        doHeapSort(arr);
    }

    //����ռ临�Ӷ�O(1)
    private static void doHeapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //��һ�ͷ���ֻ�ǰ���������ɴ����(�����鵫��һ���Ǵ�С������)
        //����һ�������Ϊ����ѵĴ��ۣ�O(N*logN) һ����һ�����ķ�
//        for (int i = 0; i < arr.length; i++) {
//            heapInert(arr, i);
//        }
        //�������������Ϊ����ѵĴ��ۣ�O(N)
        //�Ż�
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        //������
        int heapSize = arr.length;
        // �����ֵ�����������,heapSize-1,��Ҳ���ᶯ���һ����
        swap(arr, 0, --heapSize);
        //�㷨ʱ�临�Ӷ�O(logN*N)
        while (heapSize > 0) {//O(N)
            heapify(arr, 0, heapSize);//O(logN)
            swap(arr, 0, --heapSize);//O(1)
        }


    }

    /**
     * @Name heapify
     * @Param [arr, i, length]
     * @Retrun void
     * @Author Chen Langtao
     * @Date 2021/2/15 17:43
     * @Throws
     * @Description �������󲻶��³�
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        //���ӵ�����
        int leftIndex = index * 2 + 1;
        while (leftIndex < heapSize) {
            //�����ӽڵ�ֵ�ϴ��һ��������
            int largest = leftIndex + 1 < heapSize && arr[leftIndex + 1] > arr[leftIndex] ? leftIndex + 1 : leftIndex;
            //�ϴ�ڵ��뵱ǰ���׽ڵ�ϴ��һ��
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            //�����³�
            leftIndex = index * 2 + 1;
        }

    }

    /**
     * @Name
     * @Param
     * @Retrun
     * @Author Chen Langtao
     * @Date 2021/2/15 17:39
     * @Throws
     * @Description ��һ��һ����һ���������Ϊ�����
     */
    private static void heapInert(int[] arr, int i) {
        //�ҵ����ڵ�
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            //�������ϱȽϸ��ڵ�
            i = (i - 1) / 2;
        }
    }

    private static void swap(int[] heap, int index, int i) {
        int temp = heap[index];
        heap[index] = heap[i];
        heap[i] = temp;
    }

}
