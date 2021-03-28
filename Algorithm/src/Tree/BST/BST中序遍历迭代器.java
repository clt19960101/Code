package Tree.BST;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName BST�������������
 * @Author Chen Langtao
 * @Date 2021/3/28 22:23
 * @Description 173
 * @Version 1.0
 */
public class BST������������� {
    //������ʽ
    public static class BSTIterator1 {
        private TreeNode cur;
        private Stack<TreeNode> stack;

        public BSTIterator1(TreeNode root) {
            cur = root;
            stack = new Stack<TreeNode>();

        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int ret = cur.val;
            cur = cur.right;
            return ret;

        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();

        }
    }

    //��ƽ��

    /**
     * ���ǿ���ֱ�ӶԶ�����������һ����ȫ�ĵݹ��������ȡ���������ȫ������������������С�����������õõ������鱾����ʵ�ֵ�����
     */
    public static class BSTIterator2 {
        private int index;
        private List<Integer> arr;

        public BSTIterator2(TreeNode root) {
            arr = new ArrayList<Integer>();
            inOrder(root, arr);
            index = 0;
        }

        private void inOrder(TreeNode root, List<Integer> arr) {
            if (root == null) {
                return;
            }
            inOrder(root.left, arr);
            arr.add(root.val);
            inOrder(root.right, arr);

        }

        public int next() {
            return arr.get(index++);

        }

        public boolean hasNext() {
            return index < arr.size();
        }
    }

}
