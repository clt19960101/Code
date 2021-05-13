package List;

import java.util.HashSet;

/**
 * @ClassName �ཻ����
 * @Author Chen Langtao
 * @Date 2021/5/5 23:43
 * @Description 160
 * @Version 1.0
 */
public class �ཻ���� {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (!set.add(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
