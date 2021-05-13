package List;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName ɾ������ĵ�����N�����
 * @Author Chen Langtao
 * @Date 2021/5/4 22:10
 * @Description 19
 * @Version 1.0
 */
public class ɾ������ĵ�����N����� {
    public ListNode removeNthFromEnd_Stack(ListNode head, int n) {
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode dumy = new ListNode(0, head);
        ListNode cur = dumy;
        while (cur != null) {
            //���ƽڵ�Ҳ����ջ��
            stack.push(cur);
            cur = cur.next;
        }

        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dumy.next;

    }

    public ListNode removeNthFromEnd_Point(ListNode head, int n) {
        ListNode dumy = new ListNode(0, head);
        ListNode former = head;
        for (int i = 0; i < n; i++) {
            former = former.next;
        }

        //slowָ���ƽڵ㣬��former������ĩβʱ��slowָ���ɾ���ڵ��ǰһ���ڵ�
        ListNode slow = dumy;
        while (former != null) {
            former = former.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dumy.next;
    }

}


