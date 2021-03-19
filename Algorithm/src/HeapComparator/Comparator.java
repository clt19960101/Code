package HeapComparator;

import java.util.Arrays;

/**
 * @ClassName Comparator
 * @Description 比较器
 * 1.比较器的实质就是重载比较运算符
 * 2.比较器可以很好的应用在特殊标准的排序上
 * 3.比较器可以很好的应用在根据特殊标准排序结构上
 * 4.写代码变得容易，还用于泛型编程
 * @Author Langtao
 * @Date 2021/2/24 23:35
 * @Version V1.0
 */

public class Comparator {
    public static void main(String[] args) {
        Student A = new Student(1, 18, "A");
        Student B = new Student(3, 15, "B");
        Student C = new Student(2, 23, "C");
        Student[] students = new Student[]{A,B,C};
        Arrays.sort(students,new IdAscendingComparator());
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
//        //默认小根堆
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        priorityQueue.add(1);
//        priorityQueue.add(4);
//        priorityQueue.add(5);
//        priorityQueue.add(3);
//        priorityQueue.add(2);
//        //打印
//        Iterator<Integer> iterator = priorityQueue.iterator();
//        System.out.println("小根堆");
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        System.out.println("=====================");
//        System.out.println("大根堆");
//
//        //大根堆
//        PriorityQueue<Integer> priorityMaxHeapQueue = new PriorityQueue<>(new MyComparator());
//        priorityMaxHeapQueue.add(1);
//        priorityMaxHeapQueue.add(4);
//        priorityMaxHeapQueue.add(5);
//        priorityMaxHeapQueue.add(3);
//        priorityMaxHeapQueue.add(2);
//        //打印
//        Iterator<Integer> iteratorMax = priorityMaxHeapQueue.iterator();
//        while (iteratorMax.hasNext()) {
//            System.out.println(iteratorMax.next());
//        }
    }
    public static class MyComparator implements java.util.Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }

        /**
     *
     * @ClassName Comparator
     * @Description 按id升序排列
     * @Author Langtao
     * @Date 2021/2/24 23:43
     * @Version V1.0
     *
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
    }
}
