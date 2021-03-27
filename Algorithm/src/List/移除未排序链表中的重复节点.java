package List;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName �Ƴ�δ���������е��ظ��ڵ�
 * @Author Chen Langtao
 * @Date 2021/3/26 23:08
 * @Description ������ 02.01
 * @Version 1.0
 */
public class �Ƴ�δ���������е��ظ��ڵ� {
    public ListNode removeDuplicateNodes1(ListNode head) {
        if (head == null) {
            return head;
        }
        HashSet<Integer> set = new HashSet<>();
        //һ���е�һ���ڵ�
        set.add(head.val);
        ListNode curr = head;
        while (curr.next != null) {
            if (set.add(curr.next.val)) {
                curr = curr.next;
            } else {
                curr.next = curr.next.next;
            }
        }
        return head;
    }

    public ListNode removeDuplicateNodes2(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr;
            int val = temp.val;
            while (temp.next != null) {
                if (temp.next.val != val) {
                    temp = temp.next;
                } else {
                    temp.next = temp.next.next;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}
