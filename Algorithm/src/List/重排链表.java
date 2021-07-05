package List;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName ��������
 * @Description TODO
 * @Author Langtao
 * @Date 2021/5/20 22:57
 * @Version V1.0
 */

public class �������� {
    public static void main(String[] args) {
        printDefaultCapacityList();
        printEmptyCapacityList();
    }

    public static void printDefaultCapacityList() {
        ArrayList defaultCapacity = new ArrayList();
        System.out.println(
                "default ��ʼ�����ȣ�" + getCapacity(defaultCapacity));

        defaultCapacity.add(1);
        System.out.println(
                "default add ֮�� ���ȣ�" + getCapacity(defaultCapacity));
    }

    public static void printEmptyCapacityList() {
        ArrayList emptyCapacity = new ArrayList(20);
        System.out.println(
                "empty ��ʼ�����ȣ�" + getCapacity(emptyCapacity));

        emptyCapacity.add(1);
        System.out.println(
                "empty add ֮�� ���ȣ�" + getCapacity(emptyCapacity));
    }

    public static int getCapacity(ArrayList<?> arrayList) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            // ��ȡ elementData �ֶ�
            Field field = arrayListClass.getDeclaredField("elementData");
            // ��������Ȩ��
            field.setAccessible(true);
            // ��ʾ������get����ȡʵ���ֶ�elementData��ֵ
            Object[] objects = (Object[]) field.get(arrayList);
            //���ص�ǰArrayListʵ��������ֵ
            return objects.length;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode node = head;
        List<ListNode> list = new ArrayList<ListNode>();
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    public void reorderList1(ListNode head) {
        if (head == null) {
            return;
        }
        //1.�õ������е�
        ListNode middle = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = middle.next;
        middle.next = null;
        //2.��ԭ������Ұ�˷�ת
        l2 = reverseList(l2);
        //3.��ԭ��������˺ϲ�
        mergerList(l1, l2);

    }

    private void mergerList(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        while (curr1 != null && curr2 != null) {
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;
            curr1.next = curr2;
            curr1 = next1;

            curr2.next = next1;
            curr2 = next2;

        }
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
}
