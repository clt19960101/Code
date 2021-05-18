package Heap;

/**
 * @ClassName HeapSort
 * @Author Chen Langtao
 * @Date 2021/2/15 17:17
 * @Description 堆排序 1）组织成大根堆 2）排序
 * @Version 1.0
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {12, 23, 4, 2, 4, 53, 3};
        doHeapSort(arr);
    }

    //额外空间复杂度O(1)
    private static void doHeapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //法一和法二只是把数组调整成大根堆(是数组但不一定是大（小）根堆)
        //方法一：数组变为大根堆的代价：O(N*logN) 一个数一个数的放
//        for (int i = 0; i < arr.length; i++) {
//            heapInert(arr, i);
//        }
        //方法二：数组变为大根堆的代价：O(N)
        //优化
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        //排序工作
        int heapSize = arr.length;
        // 将最大值换到数组最后,heapSize-1,再也不会动最后一个数
        swap(arr, 0, --heapSize);
        //算法时间复杂度O(logN*N)
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
     * @Description 从右往左不断下沉
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        //左孩子的索引
        int leftIndex = index * 2 + 1;
        while (leftIndex < heapSize) {
            //左右子节点值较大的一个的索引
            int largest = leftIndex + 1 < heapSize && arr[leftIndex + 1] > arr[leftIndex] ? leftIndex + 1 : leftIndex;
            //较大节点与当前父亲节点较大的一个
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            //继续下沉
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
     * @Description 法一：一个数一个数的组成为大根堆
     */
    private static void heapInert(int[] arr, int i) {
        //找到父节点
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            //继续向上比较父节点
            i = (i - 1) / 2;
        }
    }

    private static void swap(int[] heap, int index, int i) {
        int temp = heap[index];
        heap[index] = heap[i];
        heap[i] = temp;
    }

}
