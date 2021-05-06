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
    //��ϣ��
    public ListNode getIntersectionNode_hash(ListNode headA, ListNode headB) {
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
    //˫ָ�뷨
    public ListNode getIntersectionNode_point(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
