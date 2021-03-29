package List;

/**
 * @ClassName 有序链表去重复
 * @Description TODO
 * @Author Langtao
 * @Date 2021/3/21 17:23
 * @Version V1.0
 */

public class 有序链表去重复 {
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
        //给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
        deleteDuplication(node0);
        //给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次
        deleteDuplication_leetcode(node0);
    }

    public static Node deleteDuplication(Node head) {
        if (head == null || head.next == null) return head;
        //因为有可能删除头节点，因此增加一个哑节点
        Node dummy = new Node(-1);
        dummy.next = head;
        //pre指向哑节点
        Node pre = dummy;
        Node cur = head;
        while (cur != null && cur.next != null) {
            //初始化的时pre指向的是哑结点，所以比较逻辑应该是pre的下一个节点和cur的下一个节点
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
