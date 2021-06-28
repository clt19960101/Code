package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName 填充每个节点的下一个右侧节点指针
 * @Description 116
 * @Author Langtao
 * @Date 2021/6/16 20:52
 * @Version V1.0
 */

public class 填充每个节点的下一个右侧节点指针 {
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
     * @Description 层次遍历：每次会拿出队列中的所有元素（即处于同一层的元素）进行操作
     * @Date 20:56 2021/6/16
     * @Param
     */

    public Node connect(Node root) {

        if (root == null) {
            return root;
        }

        //初始化队列的同时将第一层节点，即根节点放入
        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(root);
        root.next = null;
        //外层while循环的迭代的层数
        while (!nodes.isEmpty()) {
            //记录当前队列的大小
            int size = nodes.size();

            //遍历当前层的所有节点
            for (int i = 0; i < size; i++) {

                //队首节点
                Node node = nodes.poll();

                //连接
                if (i < size - 1) {
                    node.next = nodes.peek();
                }

                //拓展下一层节点
                if (node.left != null) {
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                }

            }
        }
        //返回根节点
        return root;
    }


    /**
     * @return
     * @Author Langtao
     * @Description 使用已建立的next指针
     * @Date 21:26 2021/6/16
     * @Param
     */

    public Node connect_method2(Node root) {
        if (root == null) {
            return root;
        }
        //最左节点,从根节点开始
        Node leftmost = root;

        //因为是完美二叉树，如果当前最左节点的左孩子不存在，则说明已经到达最后一层
        while (leftmost.left != null) {

            //遍历这一层节点组织成的链表，为下一层的节点更新next指针
            Node head = leftmost;

            while (head != null) {
                //情况一
                head.left.next = head.right;

                //情况二
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                //指针向后移动
                head = head.next;
            }
            //去下一层的最左节点
            leftmost = leftmost.left;
        }
        return root;
    }

}
