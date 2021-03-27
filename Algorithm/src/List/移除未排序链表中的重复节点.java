package List;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName 移除未排序链表中的重复节点
 * @Author Chen Langtao
 * @Date 2021/3/26 23:08
 * @Description 面试题 02.01
 * @Version 1.0
 */
public class 移除未排序链表中的重复节点 {
    public ListNode removeDuplicateNodes1(ListNode head) {
        if (head == null) {
            return head;
        }
        HashSet<Integer> set = new HashSet<>();
        //一定有第一个节点
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
