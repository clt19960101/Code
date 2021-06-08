package Tree.BST;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName BST中序遍历
 * @Author Chen Langtao
 * @Date 2021/3/28 11:45
 * @Description 94
 * @Version 1.0
 */
public class BST中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;

    }

    //递归实现
    public void inorder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
    public List<Integer> inorderTraversal_diedai(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            //一直操作左节点
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            //操作右子节点
            node = node.right;
        }
        return res;

    }
}
