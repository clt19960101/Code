package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName ���ÿ���ڵ����һ���Ҳ�ڵ�ָ��
 * @Description 116
 * @Author Langtao
 * @Date 2021/6/16 20:52
 * @Version V1.0
 */

public class ���ÿ���ڵ����һ���Ҳ�ڵ�ָ�� {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }


    /**
     * @return
     * @Author Langtao
     * @Description ��α�����ÿ�λ��ó������е�����Ԫ�أ�������ͬһ���Ԫ�أ����в���
     * @Date 20:56 2021/6/16
     * @Param
     */

    public Node connect(Node root) {

        if (root == null) {
            return root;
        }

        //��ʼ�����е�ͬʱ����һ��ڵ㣬�����ڵ����
        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(root);
        root.next = null;
        //���whileѭ���ĵ����Ĳ���
        while (!nodes.isEmpty()) {
            //��¼��ǰ���еĴ�С
            int size = nodes.size();

            //������ǰ������нڵ�
            for (int i = 0; i < size; i++) {

                //���׽ڵ�
                Node node = nodes.poll();

                //����
                if (i < size - 1) {
                    node.next = nodes.peek();
                }

                //��չ��һ��ڵ�
                if (node.left != null) {
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                }

            }
        }
        //���ظ��ڵ�
        return root;
    }


    /**
     * @return
     * @Author Langtao
     * @Description ʹ���ѽ�����nextָ��
     * @Date 21:26 2021/6/16
     * @Param
     */

    public Node connect_method2(Node root) {
        if (root == null) {
            return root;
        }
        //����ڵ�,�Ӹ��ڵ㿪ʼ
        Node leftmost = root;

        //��Ϊ�������������������ǰ����ڵ�����Ӳ����ڣ���˵���Ѿ��������һ��
        while (leftmost.left != null) {

            //������һ��ڵ���֯�ɵ�����Ϊ��һ��Ľڵ����nextָ��
            Node head = leftmost;

            while (head != null) {
                //���һ
                head.left.next = head.right;

                //�����
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                //ָ������ƶ�
                head = head.next;
            }
            //ȥ��һ�������ڵ�
            leftmost = leftmost.left;
        }
        return root;
    }

}
