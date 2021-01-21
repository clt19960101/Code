package List;

/**
 * @ClassName ReverseList
 * @Description 链表反转
 * @Author Langtao
 * @Date 2021/1/21 22:36
 * @Version V1.0
 */

public class ReverseList {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next=node2;
        node2.next = node3;
        DoubleNode doubleNode1 = new DoubleNode(1);
        DoubleNode doubleNode2 = new DoubleNode(2);
        DoubleNode doubleNode3 = new DoubleNode(3);
        doubleNode1.next=doubleNode2;
        doubleNode2.last = doubleNode1;
        doubleNode2.next = doubleNode3;
        doubleNode3.last = doubleNode2;
        doReverseLinkedList(node1);
        doReverseDoubleList(doubleNode1);
    }

    private static void doReverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            head = next;
        }
    }

    public static Node doReverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            //记录当前节点的下一个节点
            next = head.next;
            head.next = pre;
            pre = head;
            //头节点指向下一个节点
            head = next;
        }
        return pre;
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }
    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;
        public DoubleNode(int data) {
            value = data;
        }
    }
}
