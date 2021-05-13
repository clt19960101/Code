package List;

/**
 * @ClassName 分隔链表
 * @Author Chen Langtao
 * @Date 2021/5/5 18:58
 * @Description 86
 * @Version 1.0
 */
public class 分隔链表 {
    public ListNode partition(ListNode head, int x) {
        //新建两个链表

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
        //将largeHead.next=null eg:2->4->6->6->2
        largeHead.next = null;
        //将smallHead.next指向largeList.next即可
        smallHead.next = largeList.next;

        return smallList.next;
    }
}
