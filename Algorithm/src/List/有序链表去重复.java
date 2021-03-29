package List;

/**
 * @ClassName ��������ȥ�ظ�
 * @Description TODO
 * @Author Langtao
 * @Date 2021/3/21 17:23
 * @Version V1.0
 */

public class ��������ȥ�ظ� {
    public static void main(String[] args) {
        Node node0 = new Node(2);
        Node node1 = new Node(3);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(4);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        //����һ����������ɾ�����к����ظ����ֵĽڵ㣬ֻ����ԭʼ������ û���ظ����� �����֡�
        deleteDuplication(node0);
        //����һ����������ɾ�������ظ���Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ��
        deleteDuplication_leetcode(node0);
    }

    public static Node deleteDuplication(Node head) {
        if (head == null || head.next == null) return head;
        //��Ϊ�п���ɾ��ͷ�ڵ㣬�������һ���ƽڵ�
        Node dummy = new Node(-1);
        dummy.next = head;
        //preָ���ƽڵ�
        Node pre = dummy;
        Node cur = head;
        while (cur != null && cur.next != null) {
            //��ʼ����ʱpreָ������ƽ�㣬���ԱȽ��߼�Ӧ����pre����һ���ڵ��cur����һ���ڵ�
            if (pre.next.getValue() != cur.next.getValue()) {
                pre = pre.next;
                cur = cur.next;
            }else {
                while (cur != null && cur.next != null && pre.next.getValue() == cur.next.getValue()) {
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static Node deleteDuplication_leetcode(Node head) {
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.getValue() == curr.next.getValue()) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
