package Heap;

import java.util.PriorityQueue;

/**
 * @ClassName MaxHeap
 * @Author Chen Langtao
 * @Date 2021/2/14 18:39
 * @Description 堆首先是一个完全二叉树
 * 大根堆：每一棵子树的最大值都是这棵子树的根节点
 * 结论：一个N个节点的二叉树高度时logN级别的，也就是调整代价
 * @Version 1.0
 */
public class MaxHeap {
    public static void main(String[] args) {
        //系统默认是小根堆
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        priorityQueue.add(5);
//        priorityQueue.add(3);
//        priorityQueue.add(2);
//        priorityQueue.add(6);
//        priorityQueue.add(7);
//        Iterator<Integer> iterator = priorityQueue.iterator();
//        while (iterator.hasNext()) {
//            Integer next = iterator.next();
//            System.out.println(next);
//        }
        int[] arr = new int[]{1, 2, 4, 2, 6, 4, 7, 8, 9, 5, 3};
        //每个元素移动的距离一定不超过K
        int k = 4;
        sortArrDisLessK(arr, k);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //将给定的数组组织成大根堆
        MyMaxHeap maxHeap = new MyMaxHeap(5);
        maxHeap.push(2);
        maxHeap.push(4);
        maxHeap.push(6);
        maxHeap.push(1);
        maxHeap.push(7);
        System.out.println(maxHeap.pop());
        System.out.println(maxHeap.pop());
    }

    /**
     * @return void
     * @Author Langtao
     * @Description 已知一个几乎有序的数组。几乎有序是指，如果把数组排好序的话，每个元素移动的距离一定不超过K,
     * 并且K相对于数组长度来说是比较小的。
     * @Date 23:36 2021/2/23
     * @Param [arr, k]
     */
    private static void sortArrDisLessK(int[] arr, int k) {
        //默认小根堆
        PriorityQueue<Object> heap = new PriorityQueue<>();
        int index = 0;
        //0..K
        for (; index < Math.min(arr.length - 1, k); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            arr[i] = (int) heap.poll();
            heap.add(arr[index]);
        }
        while (!heap.isEmpty()) {
            arr[i++] = (int) heap.poll();
        }

    }

    public static class MyMaxHeap {
        private final int limit;
        private int[] heap;
        //heapSize 即是heap元素的个数，也是新增元素应放置的位置
        private int heapSize;

        public MyMaxHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            this.heapSize = 0;

        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }

        /**
         * @Name push
         * @Param [value]
         * @Retrun void
         * @Author Chen Langtao
         * @Date 2021/2/14 22:01
         * @Throws
         * @Description 新增一个数并把堆调整为大根堆
         */
        public void push(int value) {
            if (heapSize == limit) {
                throw new RuntimeException("maxHeap is full");
            }
            //存放新增数据
            heap[heapSize] = value;
            //组织大根堆
            insertHeap(heap, heapSize++);
        }

        //删除大数堆中最大的数并返回，并调整新堆也为大数堆
        public int pop() {
            //返回heap[0]
            int temp = heap[0];
            //将heap[--heapSize]的值付给heap[0],缩小堆
            swap(heap, 0, --heapSize);
            //调整新堆为大数堆
            heapify(heap, 0, heapSize);
            return temp;
        }

        //从index往下看，不断下沉，heapSize想象的新堆
        private void heapify(int[] heap, int index, int heapSize) {
            //找到当前index的左右两节点并与较大的值交换
            int leftIndex = index * 2 + 1;
            //左孩子越界，则右孩子一定越界，不越界说明有左孩子，但不一定有右孩子
            while (leftIndex < heapSize) {
                //左右孩子谁大谁胜出，但不一定有右孩子
                //右孩子胜出条件：1）必须有右孩子，即右孩子不越界 && 2）右孩子的值要大于左孩子
                //否则左孩子胜出
                int largest = leftIndex + 1 < heapSize && heap[leftIndex + 1] > heap[leftIndex] ? leftIndex + 1 : leftIndex;

                //此时largest 为两个孩子孩子中较大值的index,再比较最大值与当前父节点的值谁大
                largest = heap[largest] > heap[index] ? largest : index;
                if (largest == index) {
                    break;
                }
                swap(heap, largest, index);
                index = largest;
                //周而复始
                leftIndex = index * 2 + 1;
            }

        }

        private void insertHeap(int[] heap, int index) {
            /**
             * 大根堆下标从0开始时   大根堆下标从1开始时
             * 父节点位置：(i-1)/2   i/2 等同于 i>>1
             * 左节点位置：2*i+1     2*i 等同于 i<<1
             * 右节点位置：2*i+2     2*i+1 等同于 i<<1|1
             */
            while (heap[index] > heap[(index - 1) / 2]) {
                swap(heap, index, (index - 1) / 2);
                //继续向上比较父节点
                index = (index - 1) / 2;
            }
        }

        private void swap(int[] heap, int index, int i) {
            int temp = heap[index];
            heap[index] = heap[i];
            heap[i] = temp;
        }
    }
}
