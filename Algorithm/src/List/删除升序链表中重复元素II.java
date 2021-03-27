package List;

/**
 * @ClassName ɾ�������������ظ�Ԫ��II
 * @Author Chen Langtao
 * @Date 2021/3/26 22:08
 * @Description 82
 * @Version 1.0
 */
public class ɾ�������������ظ�Ԫ��II {
    public ListNode deleteDuplicates(ListNode head) {
        //��Ϊͷ�ڵ�������ظ���ɾ����������Ҫ�����ƽڵ�dummy;
        ListNode dummy = new ListNode(-1, head);
        //��ǰ�ڵ�ָ��dummy
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                //��¼curr.next.val
                int x = curr.next.val;
                //�ҵ��ظ��ڵ�
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
