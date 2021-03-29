package List;

/**
 * @ClassName ��ת����
 * @Description https://leetcode-cn.com/problems/rotate-list/solution/xuan-zhuan-lian-biao-by-leetcode/
 * @Author Langtao
 * @Date 2021/3/21 16:03
 * @Version V1.0
 */

public class ��ת���� {
    public static void main(String[] args) {
        Node node0 = new Node(2);
        Node node1 = new Node(3);
        Node node2 = new Node(4);
        Node node3 = new Node(5);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        int k = 3;
        rotateRight(node0, k);
    }

    /**
     * �ҵ��ɵ�β��������������ͷ���� old_tail.next = head����������պϳɻ���ͬʱ���������ĳ��� n��
     * �ҵ��µ�β������ (n - k % n - 1) ���ڵ� ���µ�����ͷ�ǵ� (n - k % n) ���ڵ㡣
     * �Ͽ��� new_tail.next = None���������µ�����ͷ new_head��
     *
     * @param head
     * @param k
     * @return
     */
    private static Node rotateRight(Node head, int k) {
        //base case
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        //�γɻ�������
        Node old_tail = head;
        //����ڵ���
        int n;
        for (n = 1; old_tail.next != null; n++) {
            old_tail = old_tail.next;
        }
        old_tail.next = head;
        //�ҵ��µ�β����n-(k%n)-1
        Node new_tail = head;
        for (int i = 0; i < n - (k % n) - 1; i++) {
            new_tail = new_tail.next;
        }
        //�µ�ͷ��:n-(k%n)
        Node new_head = new_tail.next;
        //�Ͽ�����
        new_tail.next = null;
        return new_head;
    }
}
