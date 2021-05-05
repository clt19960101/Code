package List;

/**
 * @ClassName �ָ�����
 * @Author Chen Langtao
 * @Date 2021/5/5 18:58
 * @Description 86
 * @Version 1.0
 */
public class �ָ����� {
    public ListNode partition(ListNode head, int x) {
        //�½���������

        ListNode smallList = new ListNode(0);
        ListNode smallHead = smallList;
        ListNode largeList = new ListNode(0);
        ListNode largeHead = largeList;

        while (head != null) {
            if (head.val < x) {
                smallHead.next = head;
                smallHead = smallHead.next;
            } else {
                largeHead.next = head;
                largeHead = largeHead.next;
            }
            head = head.next;
        }
        //��largeHead.next=null eg:2->4->6->6->2
        largeHead.next = null;
        //��smallHead.nextָ��largeList.next����
        smallHead.next = largeList.next;

        return smallList.next;
    }
}
