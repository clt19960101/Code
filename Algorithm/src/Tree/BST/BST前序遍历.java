package Tree.BST;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName BSTǰ�����
 * @Author Chen Langtao
 * @Date 2021/3/28 12:09
 * @Description 144
 * @Version 1.0
 */
public class BSTǰ����� {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;

    }

    //�ݹ�ʵ��
    public void preOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left,res);
        preOrder(root.right,res);
    }

    /**
     * ����
     * ά��һ��ջ
     * 1.����ջʱ�ʹ�ӡ
     * 2.��������ӽڵ���ѹ�ҽڵ�
     * 3.��������ӽڵ���ѹ��ڵ�
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
            //����ջʱ�ͼ�����
            res.add(pop.val);
            //��������ӽڵ���ѹ�ҽڵ�
            if (pop.right != null) {
                nodes.push(pop.right);
            }
            //��������ӽڵ���ѹ��ڵ�
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
            //һֱ������ڵ�
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            //�������ӽڵ�
            node = node.right;
        }
        return res;
    }

}
