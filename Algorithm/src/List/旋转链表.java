package List;

/**
 * @ClassName 旋转链表
 * @Description https://leetcode-cn.com/problems/rotate-list/solution/xuan-zhuan-lian-biao-by-leetcode/
 * @Author Langtao
 * @Date 2021/3/21 16:03
 * @Version V1.0
 */

public class 旋转链表 {
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
     * 找到旧的尾部并将其与链表头相连 old_tail.next = head，整个链表闭合成环，同时计算出链表的长度 n。
     * 找到新的尾部，第 (n - k % n - 1) 个节点 ，新的链表头是第 (n - k % n) 个节点。
     * 断开环 new_tail.next = None，并返回新的链表头 new_head。
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
        //形成环形链表
        Node old_tail = head;
        //链表节点数
        int n;
        for (n = 1; old_tail.next != null; n++) {
            old_tail = old_tail.next;
        }
        old_tail.next = head;
        //找到新的尾部：n-(k%n)-1
        Node new_tail = head;
        for (int i = 0; i < n - (k % n) - 1; i++) {
            new_tail = new_tail.next;
        }
        //新的头部:n-(k%n)
        Node new_head = new_tail.next;
        //断开链表
        new_tail.next = null;
        return new_head;
    }
}
