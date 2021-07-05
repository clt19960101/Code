package List;

/**
 * @ClassName ������м���
 * @Description TODO
 * @Author Langtao
 * @Date 2021/5/20 22:27
 * @Version V1.0
 */

public class ������м��� {
    public ListNode middleNode_1(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }

    /**
     * ��ָ�뷨
     * @param head
     * @return
     */
    public ListNode middleNode_2(ListNode head) {
        int count=0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int c = 0;
        while (c < count / 2) {
            c++;
            head = head.next;
        }
        return head;
    }
    /**
     * ����ָ�뷨
     */
    public ListNode middleNode_3(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
