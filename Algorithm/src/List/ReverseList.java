package List;

/**
 * @ClassName ReverseList
 * @Description ����ת
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
     * �ڱ�������ʱ������ǰ�ڵ�� next ָ���Ϊָ��ǰһ���ڵ㡣���ڽڵ�û��������ǰһ���ڵ㣬��˱������ȴ洢��ǰһ���ڵ㡣
     * �ڸ�������֮ǰ������Ҫ�洢��һ���ڵ㡣��󷵻��µ�ͷ����
     */
    public static Node doReverseLinkedList(Node head) {
        //��ǰ�ڵ�ǰһ���ڵ�
        Node pre = null;
        //��ǰ�ڵ�
        Node curr = head;
        while (curr != null) {
            //��¼��ǰ�ڵ����һ���ڵ�
            Node next = curr.next;
            //��ת����
            curr.next = pre;
            pre = curr;
            //ͷ�ڵ�ָ����һ���ڵ�
            curr = next;
        }
        return pre;
    }
}
