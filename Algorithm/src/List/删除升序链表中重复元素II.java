package List;

/**
 * @ClassName 删除升序链表中重复元素II
 * @Author Chen Langtao
 * @Date 2021/3/26 22:08
 * @Description 82
 * @Version 1.0
 */
public class 删除升序链表中重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        //因为头节点可能因重复而删除，所以需要建立哑节点dummy;
        ListNode dummy = new ListNode(-1, head);
        //当前节点指向dummy
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                //记录curr.next.val
                int x = curr.next.val;
                //找到重复节点
                while (curr.next != null && curr.next.val == x) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
