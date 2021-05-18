package Tree.BST;

import Tree.TreeNode;

import java.util.*;

/**
 * @ClassName BST后续遍历
 * @Author Chen Langtao
 * @Date 2021/3/28 12:10
 * @Description 145
 * @Version 1.0
 */
public class BST后续遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;

    }

    //递归实现
    public void postOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal_diedai(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        //prev就是上一个回溯的点！如果cur.right==prev,说明刚刚右子树以及访问过了，就不访问了
        TreeNode prev = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;

    }
}