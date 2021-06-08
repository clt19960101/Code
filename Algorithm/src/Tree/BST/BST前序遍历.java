package Tree.BST;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName BST前序遍历
 * @Author Chen Langtao
 * @Date 2021/3/28 12:09
 * @Description 144
 * @Version 1.0
 */
public class BST前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;

    }

    //递归实现
    public void preOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left,res);
        preOrder(root.right,res);
    }

    /**
     * 左神
     * 维护一个栈
     * 1.弹出栈时就打印
     * 2.如果有右子节点先压右节点
     * 3.如果有左子节点先压左节点
     *
     * @return
     */
    public List<Integer> preorderTraversal_zuoshen(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode pop = nodes.pop();
            //弹出栈时就加入结果
            res.add(pop.val);
            //如果有右子节点先压右节点
            if (pop.right != null) {
                nodes.push(pop.right);
            }
            //如果有左子节点再压左节点
            if (pop.left != null) {
                nodes.push(pop.left);
            }
        }
        return res;
    }


    public List<Integer> preorderTraversal_diedai(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            //一直操作左节点
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            //操作右子节点
            node = node.right;
        }
        return res;
    }

}
