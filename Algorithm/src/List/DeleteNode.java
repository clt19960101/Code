package List;

/**
 * @ClassName DeleteNode
 * @Description 删除链表中指定值的节点
 * @Author Langtao
 * @Date 2021/1/22 22:58
 * @Version V1.0
 */

public class DeleteNode {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        node1.next=node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //删除链表中值为2的节点
        int num = 2;
        doDeleteNode(node1, num);
    }

    private static Node doDeleteNode(Node head, int num) {
        //可能会删除头节点，因此先遍历链表，找到第一个不为num的节点作为新链表的头节点
        while (head != null) {
            if (head.getValue() != num) {
                break;
            }
            head = head.next;
        }
        //head为新链表的头节点
        //上一个不等于num的值
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.getValue() == num) {
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;



    }
}
