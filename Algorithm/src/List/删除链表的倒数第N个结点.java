package List;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName 删除链表的倒数第N个结点
 * @Author Chen Langtao
 * @Date 2021/5/4 22:10
 * @Description 19
 * @Version 1.0
 */
public class 删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd_Stack(ListNode head, int n) {
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode dumy = new ListNode(0, head);
        ListNode cur = dumy;
        while (cur != null) {
            //将哑节点也放入栈中
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

        //slow指向哑节点，当former到链表末尾时，slow指向待删除节点的前一个节点
        ListNode slow = dumy;
        while (former != null) {
            former = former.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dumy.next;
    }

}


