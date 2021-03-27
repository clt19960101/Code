package List;

/**
 * @ClassName 删除升序链表中重复元素I
 * @Author Chen Langtao
 * @Date 2021/3/26 22:08
 * @Description 83
 * @Version 1.0
 */
public class 删除升序链表中重复元素I {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
