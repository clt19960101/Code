package List;

/**
 * @ClassName ɾ�������������ظ�Ԫ��I
 * @Author Chen Langtao
 * @Date 2021/3/26 22:08
 * @Description 83
 * @Version 1.0
 */
public class ɾ�������������ظ�Ԫ��I {
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
