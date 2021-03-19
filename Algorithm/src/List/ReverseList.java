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
        node1.next = node2;
        node2.next = node3;
        DoubleNode doubleNode1 = new DoubleNode(1);
        DoubleNode doubleNode2 = new DoubleNode(2);
        DoubleNode doubleNode3 = new DoubleNode(3);
        doubleNode1.next = doubleNode2;
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

    /**
     * 在遍历链表时，将当前节点的 next 指针改为指向前一个节点。由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。
     * 在更改引用之前，还需要存储后一个节点。最后返回新的头引用
     */
    public static Node doReverseLinkedList(Node head) {
        //当前节点前一个节点
        Node pre = null;
        //当前节点
        Node curr = head;
        while (curr != null) {
            //记录当前节点的下一个节点
            Node next = curr.next;
            //调转方向
            curr.next = pre;
            pre = curr;
            //头节点指向下一个节点
            curr = next;
        }
        return pre;
    }
}
