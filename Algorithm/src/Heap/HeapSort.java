package Heap;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @ClassName HeapSort
 * @Description ������
 * @Author Langtao
 * @Date 2021/2/23 23:21
 * @Version V1.0
 */

public class HeapSort {
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

    }
    /**
     * @Author Langtao
     * @Description ��֪һ��������������顣����������ָ������������ź���Ļ���ÿ��Ԫ���ƶ��ľ���һ��������K,
     * ����K��������鳤����˵�ǱȽ�С�ġ�
     * @Date 23:36 2021/2/23
     * @Param [arr, k]
     * @return void
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
            arr[i] = (int)heap.poll();
            heap.add(arr[index]);
        }
        while (!heap.isEmpty()) {
            arr[i++] = (int)heap.poll();
        }

    }

}
