package HeapComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @ClassName HeapSortComparator
 * @Description 已经排好序的堆, 因为需求而修改的某些值, 要求堆也维持修改元素的顺序
 * @Author Langtao
 * @Date 2021/2/26 23:18
 * @Version V1.0
 */

public class HeapSortComparator {
    /**
     * @ClassName Comparator
     * @Description 按id升序排列
     * @Author Langtao
     * @Date 2021/2/24 23:43
     * @Version V1.0
     */
    public static class IdAscendingComparator implements java.util.Comparator<Student> {
        //规则：<:-1，=:0，>:1
        @Override
        public int compare(Student o1, Student o2) {
//            if (o1.id < o2.id) {
//                return -1;
//            } else if (o1.id == o2.id) {
//                return 0;
//            } else {
//                return 1;
//            }
            return o1.getId() - o2.getId();
        }

        public static void main(String[] args) {
            MyHeap<Student> studentMyHeap = new MyHeap<>(new IdAscendingComparator());
            Student tom = new Student(2, 3, "tom");
            Student jim = new Student(6, 2, "jim");
            Student sf = new Student(3, 5, "3sf");
            Student gds = new Student(1, 8, "gds");
            Student gdcd = new Student(8, 9, "gdcd");
            studentMyHeap.push(tom);
            studentMyHeap.push(jim);
            studentMyHeap.push(sf);
            studentMyHeap.push(gds);
            studentMyHeap.push(gdcd);

            ArrayList<Student> heap = studentMyHeap.heap;
            for (Student student : heap) {
                System.out.println(student.toString());
            }

            //改变某些student的值
            System.out.println("=======================");
            tom.setId(5);
            studentMyHeap.resign(tom);
            gdcd.setId(4);
            studentMyHeap.resign(gdcd);

            ArrayList<Student> newHeap = studentMyHeap.heap;
            for (Student student : newHeap) {
                System.out.println(student.toString());
            }

        }

        public static class MyHeap<T> {
            //动态数组实现堆
            private ArrayList<T> heap;
            //记录任何样本在堆上的位置
            private HashMap<T, Integer> indexMap;
            private int heapSize;
            private Comparator<? super T> comparator;


            /**
             * @return
             * @Author Langtao
             * @Description 建立堆的时候传入比较器来明确如何比大小
             * @Date 23:27 2021/2/26
             * @Param
             */
            public MyHeap(Comparator<? super T> comparator) {
                this.heap = new ArrayList<>();
                this.indexMap = new HashMap<>();
                heapSize = 0;
                this.comparator = comparator;
            }

            public boolean isEmpty() {
                return heapSize == 0;
            }

            public int size() {
                return heapSize;
            }

            /**
             * @return
             * @Author Langtao
             * @Description 此元素是否被收录过
             * @Date 23:31 2021/2/26
             * @Param
             */
            public boolean contains(T key) {
                return indexMap.containsKey(key);
            }

            public void push(T value) {
                heap.add(value);
                indexMap.put(value, heapSize);
                heapInsert(heapSize++);
            }

            private void heapInsert(int index) {
                while (comparator.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
                    swap(index, (index - 1) / 2);
                    index = (index - 1) / 2;
                }
            }

            public T pop() {
                T t = heap.get(0);
                int end = heapSize - 1;
                //把零位置和最后一个位置的数交换
                swap(0, end);

                //强同步
                heap.remove(end);
                indexMap.remove(t);
                heapfiy(0, --heapSize);
                return t;
            }

            public void resign(T value) {
                int valueIndex = indexMap.get(value);
                //只能走其中一个
                heapInsert(valueIndex);
                heapfiy(valueIndex, heapSize);
            }

            private void heapfiy(int index, int heapSize) {
                int left = index * 2 + 1;
                while (left < heapSize) {
                    int largest = left + 1 < heapSize && comparator.compare(heap.get(left), heap.get(left + 1)) < 0 ? left + 1 : left;
                    largest = comparator.compare(heap.get(largest), heap.get(index)) < 0 ? largest : index;
                    if (largest == index) {
                        break;
                    }
                    swap(largest, index);
                    index = largest;
                    left = index * 2 + 1;

                }
            }

            private void swap(int i, int j) {
                T o1 = heap.get(i);
                T o2 = heap.get(j);
                //保证heap和indexMap强同步
                heap.set(i, o2);
                heap.set(j, o1);
                indexMap.put(o1, j);
                indexMap.put(o2, i);
            }

        }

    }
}
