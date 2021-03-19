package HeapComparator;

import java.util.Arrays;

/**
 * @ClassName Comparator
 * @Description �Ƚ���
 * 1.�Ƚ�����ʵ�ʾ������رȽ������
 * 2.�Ƚ������Ժܺõ�Ӧ���������׼��������
 * 3.�Ƚ������Ժܺõ�Ӧ���ڸ��������׼����ṹ��
 * 4.д���������ף������ڷ��ͱ��
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
//        //Ĭ��С����
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        priorityQueue.add(1);
//        priorityQueue.add(4);
//        priorityQueue.add(5);
//        priorityQueue.add(3);
//        priorityQueue.add(2);
//        //��ӡ
//        Iterator<Integer> iterator = priorityQueue.iterator();
//        System.out.println("С����");
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        System.out.println("=====================");
//        System.out.println("�����");
//
//        //�����
//        PriorityQueue<Integer> priorityMaxHeapQueue = new PriorityQueue<>(new MyComparator());
//        priorityMaxHeapQueue.add(1);
//        priorityMaxHeapQueue.add(4);
//        priorityMaxHeapQueue.add(5);
//        priorityMaxHeapQueue.add(3);
//        priorityMaxHeapQueue.add(2);
//        //��ӡ
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
     * @Description ��id��������
     * @Author Langtao
     * @Date 2021/2/24 23:43
     * @Version V1.0
     *
     */
    public static class IdAscendingComparator implements java.util.Comparator<Student> {
        //����<:-1��=:0��>:1
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
