package Heap;

import java.util.PriorityQueue;

/**
 * @ClassName MaxHeap
 * @Author Chen Langtao
 * @Date 2021/2/14 18:39
 * @Description ��������һ����ȫ������
 * ����ѣ�ÿһ�����������ֵ������������ĸ��ڵ�
 * ���ۣ�һ��N���ڵ�Ķ������߶�ʱlogN����ģ�Ҳ���ǵ�������
 * @Version 1.0
 */
public class MaxHeap {
    public static void main(String[] args) {
        //ϵͳĬ����С����
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
        //ÿ��Ԫ���ƶ��ľ���һ��������K
        int k = 4;
        sortArrDisLessK(arr, k);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //��������������֯�ɴ����
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
     * @Description ��֪һ��������������顣����������ָ������������ź���Ļ���ÿ��Ԫ���ƶ��ľ���һ��������K,
     * ����K��������鳤����˵�ǱȽ�С�ġ�
     * @Date 23:36 2021/2/23
     * @Param [arr, k]
     */
    private static void sortArrDisLessK(int[] arr, int k) {
        //Ĭ��С����
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
        //heapSize ����heapԪ�صĸ�����Ҳ������Ԫ��Ӧ���õ�λ��
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
         * @Description ����һ�������Ѷѵ���Ϊ�����
         */
        public void push(int value) {
            if (heapSize == limit) {
                throw new RuntimeException("maxHeap is full");
            }
            //�����������
            heap[heapSize] = value;
            //��֯�����
            insertHeap(heap, heapSize++);
        }

        //ɾ���������������������أ��������¶�ҲΪ������
        public int pop() {
            //����heap[0]
            int temp = heap[0];
            //��heap[--heapSize]��ֵ����heap[0],��С��
            swap(heap, 0, --heapSize);
            //�����¶�Ϊ������
            heapify(heap, 0, heapSize);
            return temp;
        }

        //��index���¿��������³���heapSize������¶�
        private void heapify(int[] heap, int index, int heapSize) {
            //�ҵ���ǰindex���������ڵ㲢��ϴ��ֵ����
            int leftIndex = index * 2 + 1;
            //����Խ�磬���Һ���һ��Խ�磬��Խ��˵�������ӣ�����һ�����Һ���
            while (leftIndex < heapSize) {
                //���Һ���˭��˭ʤ��������һ�����Һ���
                //�Һ���ʤ��������1���������Һ��ӣ����Һ��Ӳ�Խ�� && 2���Һ��ӵ�ֵҪ��������
                //��������ʤ��
                int largest = leftIndex + 1 < heapSize && heap[leftIndex + 1] > heap[leftIndex] ? leftIndex + 1 : leftIndex;

                //��ʱlargest Ϊ�������Ӻ����нϴ�ֵ��index,�ٱȽ����ֵ�뵱ǰ���ڵ��ֵ˭��
                largest = heap[largest] > heap[index] ? largest : index;
                if (largest == index) {
                    break;
                }
                swap(heap, largest, index);
                index = largest;
                //�ܶ���ʼ
                leftIndex = index * 2 + 1;
            }

        }

        private void insertHeap(int[] heap, int index) {
            /**
             * ������±��0��ʼʱ   ������±��1��ʼʱ
             * ���ڵ�λ�ã�(i-1)/2   i/2 ��ͬ�� i>>1
             * ��ڵ�λ�ã�2*i+1     2*i ��ͬ�� i<<1
             * �ҽڵ�λ�ã�2*i+2     2*i+1 ��ͬ�� i<<1|1
             */
            while (heap[index] > heap[(index - 1) / 2]) {
                swap(heap, index, (index - 1) / 2);
                //�������ϱȽϸ��ڵ�
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
