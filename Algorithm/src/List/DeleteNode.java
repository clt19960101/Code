package List;

/**
 * @ClassName DeleteNode
 * @Description ɾ��������ָ��ֵ�Ľڵ�
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
        //ɾ��������ֵΪ2�Ľڵ�
        int num = 2;
        doDeleteNode(node1, num);
    }

    private static Node doDeleteNode(Node head, int num) {
        //���ܻ�ɾ��ͷ�ڵ㣬����ȱ��������ҵ���һ����Ϊnum�Ľڵ���Ϊ�������ͷ�ڵ�
        while (head != null) {
            if (head.getValue() != num) {
                break;
            }
            head = head.next;
        }
        //headΪ�������ͷ�ڵ�
        //��һ��������num��ֵ
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
